import java.io.File;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.interactive.action.PDActionJavaScript;
import org.apache.pdfbox.Loader;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Generating embeded javascript file starting ...");
        File file = new File("safe_sample.pdf");
        PDDocument document = Loader.loadPDF(file);

        String javaScript = "app.alert( {cMsg: 'this is an example', nIcon: 3,"
                + " nType: 0, cTitle: 'PDFBox Javascript example'} );";

        // Creating PDActionJavaScript object
        PDActionJavaScript PDAjavascript = new PDActionJavaScript(javaScript);

        // Embedding javascript
        document.getDocumentCatalog().setOpenAction(PDAjavascript);
        document.save("js_embeded.pdf");
        document.close();
    }
}
