package Controllers.WebPages;

import Controllers.BaseServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;

/**
 * CREATED BY Emil @ 15-01-2022 - 18:11
 **/

@WebServlet(name = "UploadServlet")
@MultipartConfig(fileSizeThreshold = 1024 * 1024, // 1 MB
        maxFileSize = 1024 * 1024 * 5, // 5MB
        maxRequestSize = 1024 * 1024 * 10 // 10 MB
)

public class UploadServlet extends BaseServlet {
    private String path = "C:\\Users\\melo-\\IdeaProjects\\CPHB_SC_Security_project\\Upload\\";


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.setUp(request,response);
        Part filePart = request.getPart( "file");
        String fileName = filePart .getSubmittedFileName();
        for(Part part : request.getParts()) {
            part.write(path + fileName );
        }
        response.getWriter().print("The file uploaded sucessfully.");
    }
   /** public void validateFile() {
        logger.debug("Checking magic content");
        Magic parser = new Magic() ;
        MagicMatch match;
        match = parser.getMagicMatch(photoFile.getFileData());
        logger.debug("Actual file mimetype=" + match.getMimeType()) ;
    }
    **/
}
