package Service;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

/**
 * CREATED BY Emil @ 20-01-2022 - 17:44
 **/
class QRCode {

    @Test
    void createQRCode() throws WriterException, FileNotFoundException {
        int height = 3;
        int width = 3;
        String filePath = "E:\\Semester 4\\";
        String barCodeData = "otpauth://totp/Solidcode%3Amelo-maxi%26%2364%3Bhotmail.com?secret=VTRQWCKRWIP2HRHWA76WO4CW2DU3XBTE&issuer=Solidcode";
        {
            BitMatrix matrix = new MultiFormatWriter().encode(barCodeData, BarcodeFormat.QR_CODE,
                    width, height);
            try (FileOutputStream out = new FileOutputStream(filePath)) {
                MatrixToImageWriter.writeToStream(matrix, "png", out);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}