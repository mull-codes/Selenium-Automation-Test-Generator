package com.k00217982.fyp.interfaces;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public interface CustomJSoup {
	void scrapeWebPage(Document document);
	void identifyElement(Element element);
	void generateObjectMethods(Elements elements);
	void generateTestMethods(Elements elements);
}
