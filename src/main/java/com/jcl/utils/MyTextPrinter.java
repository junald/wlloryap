package com.jcl.utils;

import com.jcl.company.CompanySetting;
import com.jcl.utilities.MyDateFormatter;
import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;

/*
 * Created on Aug 4, 2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
/**
 * @author junald
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class MyTextPrinter {

    String filename;
    FileOutputStream fos;
    BufferedOutputStream bos;
    int lineCount;
    DecimalFormat df;
    final String SPACE80 = "                                                                                ";// 80 characters width
    final int DECIMAL_LENGTH = 13;
    StringBuffer sb;

    public MyTextPrinter(String filename) {
        this.filename = filename;

        sb = new StringBuffer();

        try {
            fos = new FileOutputStream(filename);
            bos = new BufferedOutputStream(fos);
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        df = new DecimalFormat("##,###,###.00");

    }

    public void writeText(String s) throws IOException { // one line at a time

        //bos.write(s.getBytes() );           
        sb.append(s);
        newLine();
        lineCount++;
    }

    /**
     *
     * @param location = number of space from left
     * @param s = text
     * @param alignment = alignment (1=leff , 2 = right)
     * @throws IOException
     */
    public void writeText(int location, String s, int alignment) throws IOException {
        //1=left, 2=right

        //bos.write(spaces80.substring(0,location).getBytes());
        sb.append(SPACE80.substring(0, location));
        switch (alignment) {
            case 1: {  // left
                //bos.write(textFormatLeftAlign(s).getBytes());
                sb.append(textFormatLeftAlign(s));
                break;
            }
            case 2: {  // rigth
                //bos.write(textFormatRightAlign(s).getBytes());
                sb.append(textFormatRightAlign(s));
                break;
            }
        }

        newLine();
        lineCount++;
    }

    public void newLine() throws IOException {
        sb.append("\n");
        //bos.write("\n".getBytes() );
    }

    public void newPage() throws IOException {
        lineCount = 0;
        sb.append("\f");
        //bos.write("\f".getBytes());
    }

    public void mark() {
        SimpleDateFormat sdf = MyDateFormatter.getDateTimeFormatter();
        sb.append(sdf.format(new java.util.Date()) + "\f");
    }

    public void close() throws IOException {
        SimpleDateFormat sdf = MyDateFormatter.getDateTimeFormatter();
        sb.append(sdf.format(new java.util.Date()) + "\f");
        //bos.write((new java.util.Date()).toString().getBytes());
        //bos.write("\f".getBytes());
        bos.write(sb.toString().getBytes());
        bos.flush();
        bos.close();
        fos.flush();
        fos.close();

    }

    /**
     *
     * @param s = text
     * @param a = alignment
     * @param l = max text length
     * @return
     */
    public String textFormatAlign(String s, int a, int l) {

        String s2 = "";

        if (l < s.length()) {
            l = s.length();
        }

        if (a == 1) {
            s2 = s + SPACE80.substring(0, (l - s.length()));
        }

        if (a == 2) {
            s2 = SPACE80.substring(0, (l - s.length())) + s;
        }

        if (a == 3) {
            String centerspace = SPACE80.substring(0, (l - s.length()) / 2);
            s2 = centerspace + s + centerspace;
        }

        return s2;

    }

    public String textFormatLeftAlign(String s) {
        return SPACE80.substring(0, (DECIMAL_LENGTH - s.length())) + s;
    }

    public String textFormatRightAlign(String s) {
        return s + SPACE80.substring(0, (DECIMAL_LENGTH - s.length()));
    }

    public void centerText(String s, boolean b) throws IOException {
        //b = bold
        int blankSpace = (80 - s.length()) / 2;
        //bos.write(spaces80.substring(0,blankSpace).getBytes());
        sb.append(SPACE80.substring(0, blankSpace));
        if (b) {
            String newText = "\u0105" + s + "\u0106";
            sb.append(("\u0105" + s + "\u0106"));
            //bos.write(("\u0105"+ s +"\u0106").getBytes() );
        } else {
            sb.append(s);
            //bos.write(s.getBytes() );
        }
        newLine();
        lineCount++;

    }

    /**
     *
     * @param c = spaces in between each columns 0 = usually the first column
     * @param l = string length
     * @param a = alignment  (1=left, 2=right, 3=center)
     * @param s = text in each column
     * @throws IOException
     */
    public void textRowData(int[] c, int[] l, int[] a, String[] s) throws IOException {
        //c = spaces in each columns, s = text in each column, a = alignment
        //l = string length
        //StringBuffer sb = new StringBuffer();

        for (int i = 0; i < s.length; i++) {

            sb.append(SPACE80.substring(0, c[i]));
            sb.append(textFormatAlign(s[i], a[i], l[i]));

        }

        //bos.write(sb.toString().getBytes());        
        newLine();
        lineCount++;
    }

    public void headers(CompanySetting cs) {
    }

    public void footers() {
    }

    public void printTxt(String loc) {
        String newf = loc + "/" + filename;
        System.out.println(newf);
        try {
            Process p = Runtime.getRuntime().exec("type " + newf + " > printer");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        MyTextPrinter tp = new MyTextPrinter("printout1.txt"); // "LPT1"
        //	MyTextPrinter tp = new MyTextPrinter("LPT1"); // "LPT1"
        DecimalFormat df1 = new DecimalFormat("##,###,###.00");
        try {
            //  tp.centerText("Title",true);
            tp.writeText("The Quick brown fox ");
            tp.writeText("jump over the lazy dog. ");
            tp.writeText(40, "123.00", 1);
            tp.writeText(40, "123.00", 2);
            tp.writeText(40, "34,123.00", 1);
            tp.writeText(40, "123.10", 1);
            tp.writeText(40, "34,123.10", 1);
            tp.writeText(40, "23,334,123.01", 2);
            int[] c = {0, 10, 10, 10, 10, 10};
            int[] l = {7, 7, 7, 7, 7, 10};
            int[] a = {1, 2, 1, 1, 1, 3};
            String[] s = {"Title0", "Title1", "Title2", "Title3", "Title4", "Title5"};

            tp.textRowData(c, l, a, s);
            String[] s1 = {df1.format(123456789.00), df1.format(34.20), df1.format(4553.00), df1.format(3222.01), df1.format(432.1), df1.format(444)};
            tp.textRowData(c, l, a, s1);
            tp.textRowData(c, l, a, s1);
            tp.textRowData(c, l, a, s1);
            tp.textRowData(c, l, a, s1);


            int[] c1 = {0, 10, 10, 10, 10};
            int[] l1 = {1, 1, 1, 1, 1};
            int[] a1 = {1, 1, 1, 1, 1};
            String[] s2 = {"12345678", "1234567", "1234567", "12345678", "12345678"};
            tp.textRowData(c1, l1, a1, s2);
//            int[] l1 = {

            tp.close();

            //DosPrint dp = new DosPrint("printout1.txt");
            //dp.startPrinting();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }




        //   tp.printTxt();
  /*      try {
        //System.out.println(" cat ju1.txt > /home/junald/j.txt ");
        //Process p = Runtime.getRuntime().exec("konsole -e ./print.bat");
        Process p = Runtime.getRuntime().exec("print.bat");

        //            try {
        //                Thread.sleep(5000);
        //            } catch (InterruptedException e2) {
        //                // TODO Auto-generated catch block
        //                e2.printStackTrace();
        //            }
        //            if(p.exitValue()==0){
        //                System.out.println("success");
        //            }

        } catch (IOException e1) {
        // TODO Auto-generated catch block
        e1.printStackTrace();
        }*/
    }
}

/*
Some commonly used escape codes include (in decimal values) - Reset (27, 64); 
Set page length in lines (27, 67, n - where n is a number from 1 to 127); 
Carriage return (13); Line feed (10); 
Form feed (12); 
Select 1/8-inch line spacing (27, 48); 
10 cpi (27, 80); 
12 cpi (27, 77); 
Select bold font (27, 69); 
Cancel bold font (27, 70); 
Select italic font (27, 52); 
Cancel italic font (27, 53); 
Turn underline on/off (27, 45, n - where n equals 49=ON or 48=OFF); 
Select condensed print (15); 
Cancel condensed print (18). 
For more escape codes, please refer to the Command Summary of your User's Manual.
\27
=================
\b			 \u0008: backspace BS 
\ t			 \u0009: horizontal tab HT 
\ n			 \u000a: linefeed LF 
\ f			 \u000c: form feed FF 
\ r			 \u000d: carriage return CR 
\ "			 \u0022: double quote " 
\ '			 \u0027: single quote ' 
\ \			 \u005c: backslash \ 

//form feed -- this is important
//Without the form feed, the text will simply sit
// in print buffer until something else gets printed.
ps2.print("\f");

OctalEscape		 \u0000 to \u00ff: from octal value 
char[] myCharArray = {29, 86, 102}

I know the "H" inside the <H> cannot be a hex value.... H is not valid hex, it only goes to F. I suspect that you made a transciption error somewhere.

If hex values are 1D, 56, 66 then the decimal values are 29,86,102.
byte[] bArray = {29,86,102}
 */
