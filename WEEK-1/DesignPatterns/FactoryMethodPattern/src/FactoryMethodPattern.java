public class FactoryMethodPattern {
    public static void main(String[] args) throws Exception {
        DocFactory wordFactory = new WordDocumentFactory();
        Documents wordDoc = wordFactory.createDocument();
        wordDoc.read();
        wordDoc.write("This is Word file being written here");
        wordDoc.save();
        wordDoc.close();

        System.out.println();

        DocFactory pdfFactory = new PdfDocumentFactory();
        Documents pdfDoc = pdfFactory.createDocument();
        pdfDoc.read();
        pdfDoc.write("This is pdf file begin written here");
        pdfDoc.save(); pdfDoc.close();

        System.out.println();
        
        DocFactory xlsFactory = new XlsDocumentFactory();
        Documents xlsDoc = xlsFactory.createDocument();
        xlsDoc.read();
        xlsDoc.write("This is excel document being written");
        xlsDoc.save();xlsDoc.close();
    }
}
