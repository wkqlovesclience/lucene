package com.sclience;

import com.sclience.poem.entity.Poet;
import com.sclience.poem.entity.Poetry;
import com.sclience.poem.service.PoetServiceImpl;
import com.sclience.poem.service.PoetryServiceImpl;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.IntField;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.store.FSDirectory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PoemApplicationTests {
	@Autowired
	private PoetServiceImpl ps;
	@Autowired
	private PoetryServiceImpl poetryService;

	@Test
	public void contextLoads() throws Exception {
		List<Poetry> list = poetryService.queryAllPoetry();
		FSDirectory fsDirectory = FSDirectory.open(Paths.get("D:\\game\\poem"));
		IndexWriter indexWriter = new IndexWriter(fsDirectory,new IndexWriterConfig(new StandardAnalyzer()));

		for (Poetry poetry : list) {
			Document document = new Document();
			document.add(new IntField("id",poetry.getPoetry_id(),Field.Store.YES));
			document.add(new TextField("title",poetry.getPoetry_title(),Field.Store.YES));
			document.add(new TextField("content",poetry.getPoetry_content(),Field.Store.YES));
			document.add(new TextField("author",poetry.getPoet().getPoet_name(),Field.Store.YES));
			indexWriter.addDocument(document);

		}
		indexWriter.flush();
		indexWriter.commit();
	}

	@Test
	public void poet() throws IOException {
		List<Poet> list = ps.queryAllPoet();
		FSDirectory fsDirectory = FSDirectory.open(Paths.get("D:\\game\\poet"));
		IndexWriter indexWriter = new IndexWriter(fsDirectory,new IndexWriterConfig(new StandardAnalyzer()));
		for (Poet poet : list) {
			Document document = new Document();
			document.add(new IntField("id",poet.getPoet_id(),Field.Store.YES));
			document.add(new TextField("name",poet.getPoet_name(),Field.Store.YES));
			indexWriter.addDocument(document);
		}
		indexWriter.flush();
		indexWriter.commit();
	}

}
