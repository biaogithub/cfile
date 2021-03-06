package biao.zxing;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.google.zxing.MultiFormatWriter;
import java.io.File;
import java.nio.file.Path;
import java.util.HashMap;

public class Demo1 {
    public static void main(String[] args) {
        int width=300;
        int height=300;
        String format="png";
        String content="www.baidu.com";
        HashMap hints=new HashMap();
        hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
        hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.M);
        hints.put(EncodeHintType.MARGIN, 2);
        try{
            BitMatrix bitMatrix=new MultiFormatWriter().encode("看什么看，没见过啊", BarcodeFormat.QR_CODE, width, height,hints);
            Path file=new File("/home/biao/img.png").toPath();
            MatrixToImageWriter.writeToPath(bitMatrix, format, file);
            System.out.println("二维码生成成功");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
