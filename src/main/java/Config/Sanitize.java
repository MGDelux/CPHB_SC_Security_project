package Config;

import Controllers.BaseServlet;
import org.owasp.html.HtmlPolicyBuilder;
import org.owasp.html.PolicyFactory;

/**
 * CREATED BY Emil @ 18-11-2021 - 15:34
 **/
public class Sanitize extends BaseServlet {
    public static PolicyFactory policy = new HtmlPolicyBuilder()
            .allowUrlProtocols("https")
            .allowAttributes("href").onElements("a")
            .requireRelNofollowOnLinks()
            .toFactory();

    public static String santizeHTML(String strng) {
        return policy.sanitize(strng);
    }
}
