package com.cmdi.sottle.utils;

import com.cmdi.sottle.entity.MroMeasurement;
import org.dom4j.io.SAXReader;
import org.dom4j.Document;
import java.io.IOException;

import org.dom4j.Attribute;
import org.dom4j.DocumentException;
import org.dom4j.Element;

import java.io.File;
import java.util.Iterator;
import java.util.List;



import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

/*
 *信息描述，如：类实体名
 *@author Mr.Rong
 *@CreateDate
 */
public class XmlparsingUtils {

    public  void xmlparsingMethor() throws IOException, DocumentException {

        //1.创建Reader对象
        SAXReader reader = new SAXReader();
        //2.加载xml
        Document document = reader.read(new File("D:\\file.text"));
        //3.获取根节点
        Element rootElement = document.getRootElement();
        Iterator iterator = rootElement.elementIterator();
        while (iterator.hasNext()){
            Element stu = (Element) iterator.next();
            List<Attribute> attributes = stu.attributes();
            System.out.println("======获取属性值======");
            for (Attribute attribute : attributes) {
                System.out.println(attribute.getValue());
            }
            System.out.println("======遍历子节点======");
            Iterator iterator1 = stu.elementIterator();
            while (iterator1.hasNext()){
                Element stuChild = (Element) iterator1.next();
                System.out.println("节点名："+stuChild.getName()+"---节点值："+stuChild.getStringValue());
            }
        }

    }
    public  void xmlparsingSAXMethor() throws ParserConfigurationException, SAXException, IOException {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        //获取SAXParse实例
        SAXParser saxParser = factory.newSAXParser();
        //创建handle对象
        SAXDemoHandel handel = new SAXDemoHandel();
        saxParser.parse("D:\\file.text", handel);
    }
}

class SAXDemoHandel extends DefaultHandler {
    private String currentTag = null;
    private MroMeasurement student = null;




    //遍历XML文件开始的标签
    @Override
    public void startDocument() throws SAXException {
        super.startDocument();
        System.out.println("sax解析开始...");
    }

    //遍历XML文件结束标签
    @Override
    public void endDocument() throws SAXException {
        super.endDocument();
        System.out.println("sax解析结束...");
    }


    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException
    {
        currentTag = qName;
        if ("学生".equals(currentTag))
        {
            student = new Student();
            student.setName(attributes.getValue("姓名"));
            student.setStudentId(attributes.getValue("学号"));
            student.setAcademy(attributes.getValue("学院"));
        }





    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        super.startElement(uri, localName, qName, attributes);
        if (qName.equals("student")) {
            System.out.println("===开始遍历student===");
        } else if (!qName.equals("student") && !qName.equals("class")) {
            System.out.println("节点名称:" + qName + "----");
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        super.endElement(uri, localName, qName);
        if (qName.equals("student")) {
            System.out.println(qName + "遍历结束");
            System.out.println("===结束遍历student===");
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        super.characters(ch, start, length);
        String value = new String(ch, start, length).trim();
        if (!value.equals("")) {
            System.out.println(value);
        }
    }
}


