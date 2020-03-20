import Services.ConstructorService;
import Services.Converter;
import Services.IConstructorService;
import Services.ParserService;
import abstraction.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeMap;

public class Run {
    public static void main(String args[])
    {
        try {
            generateWBElement();

        }catch (Exception e)
        {
            e.printStackTrace();
        }
        ///generate type
        WBAbstractElement wbAbstractElement = new WBAbstractElement();
        try {
            wbAbstractElement.setValue("comment");
        } catch (Exception e) {
            e.printStackTrace();
        }
        ///
        ConstructorService constructorService = ConstructorService.newInstance();
        constructorService.generateFile("wbExample","C:\\Sandboxes\\plasma\\whitebox\\wb");
        StringBuilder stringBuilder = constructorService.getFileContent(constructorService.getFile());
        System.out.print(stringBuilder);
        constructorService.writeIn(stringBuilder.toString(),constructorService.getFile());
        stringBuilder = constructorService.getFileContent(constructorService.getFile());
        System.out.println(stringBuilder.toString());

        /// parsing

        ParserService parserService = new ParserService(constructorService);
        ArrayList<String> parents = parserService.getParents();
        System.out.println("the following list is the parent list : ");
        for (String parent:parents)
        {
            System.out.println(parent);
        }
        System.out.println("the following list is the children list : ");
        parserService.getChildren().forEach(System.out::println);
        System.out.println("-------------------------------------------");
        ////trying converter's asTreeMap method
        Converter c = new Converter(constructorService);
        ArrayList<String> hm = (ArrayList<String>)c.asArrayList();
        System.out.println("hm size :"+hm.size());
        hm.forEach(System.out::println);

    }
    public static void generateWBElement() throws Exception
    {
        WBType wbType =new WBType("parent");
        WBKey wbKey = new WBKey("p");
        WBValue wbValue = new WBValue("test");
        WBObject wbObject = new WBObject(wbType,wbKey,wbValue);
        System.out.println("wbObject : "+wbObject.getType().getValue()+wbObject.getKey().getValue()+wbObject.getValue().getValue());
    }
    // TODO: 20/03/2020 generate a file from wb Object
}
