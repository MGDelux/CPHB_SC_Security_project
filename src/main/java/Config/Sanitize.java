package Config;

import Controllers.BaseServlet;
import org.owasp.html.HtmlPolicyBuilder;
import org.owasp.html.PolicyFactory;

/**
 * CREATED BY Emil @ 18-11-2021 - 15:34
 **/
public class Sanitize extends BaseServlet {
    PolicyFactory policy = new HtmlPolicyBuilder()
            .allowElements("a")
            .allowUrlProtocols("https")
            .allowAttributes("href").onElements("a")
            .requireRelNofollowOnLinks()
            .toFactory();
  //  String safeHTML = policy.sanitize(untrustedHTML);
}
