package com.example.blog.transformer;

import org.springframework.stereotype.Component;

@Component
public class ContentTransformer {
    public ContentTransformer() {
    }

    public String transform(String content) {
        content = content.replace("\n", "<br />");
        content = content.replace("\t", "&emsp;");
        return content;
    };
}
