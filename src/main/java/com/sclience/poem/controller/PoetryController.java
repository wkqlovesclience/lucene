package com.sclience.poem.controller;

import com.sclience.poem.entity.Poet;
import com.sclience.poem.entity.Poetry;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.search.highlight.*;
import org.apache.lucene.store.FSDirectory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;

import static jdk.internal.org.objectweb.asm.commons.GeneratorAdapter.AND;

/**
 * Created by 王克强 on 2018/7/16.
 */
@Controller
public class PoetryController {
    @RequestMapping("/search")
    public ModelAndView search(ModelAndView modelAndView,String keyword,String field) throws Exception {
        String path = null;
        if (field.equals("author")){
            path = "D:\\game\\poet";
        }else{
            path = "D:\\game\\poem";

        }
        FSDirectory fsDirectory = FSDirectory.open(Paths.get(path));
        IndexReader indexReader = DirectoryReader.open(fsDirectory);
        IndexSearcher indexSearcher = new IndexSearcher(indexReader);
        QueryParser queryParser = new QueryParser(field,new StandardAnalyzer());
        Query query = queryParser.parse(keyword);
        TopDocs topDocs = indexSearcher.search(query,1000);


        System.out.println("符合条件的记录条数："+topDocs.totalHits);

        // 高亮器
        Scorer scorer = new QueryScorer(query);
        Formatter formatter = new SimpleHTMLFormatter("<span style='color:blue;font-size:20px'>","</span>");
        Highlighter highlighter = new Highlighter(formatter,scorer);

        // 分数文档对象 文档得分 + 文档在索引库中的编号
        ScoreDoc[] scoreDocs = topDocs.scoreDocs;

        ArrayList<Poetry> poetries = new ArrayList<Poetry>();


        for (ScoreDoc scoreDoc : scoreDocs) {
            System.out.println("文档的得分："+scoreDoc.score); //lucene 分数自动相关度排序
            int docID = scoreDoc.doc;
            System.out.println("文档在数据存储区中的编号："+docID);
            Document document = indexReader.document(docID);
            String content = highlighter.getBestFragment(new StandardAnalyzer(), "content", document.get("content"));

            Poetry poetry = new Poetry();
            poetry.setPoetry_id(Integer.parseInt(document.get("id")));
            poetry.setPoetry_title(document.get("title"));
            poetry.setPoetry_content(content);
            poetry.setPoet(new Poet(0,document.get("author"),null,null,null));
            poetries.add(poetry);
        }

        modelAndView.addObject("result",poetries);
        modelAndView.setViewName("result");
        return modelAndView;
    }

}
