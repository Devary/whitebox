import Services.ConstructorService;
import Services.IConstructorService;
import Services.ParserService;

import java.util.ArrayList;

public class Run {
    public static void main(String args[])
    {
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

    }
}
