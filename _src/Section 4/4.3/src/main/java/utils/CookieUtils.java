package utils;

import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import static java.nio.charset.StandardCharsets.UTF_8;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Anghel Leonard
 */
public final class CookieUtils {

    private static final String INVALID_NAME
            = "The cookie name cannot be null or empty";
    private static final String UTF8_UNSUPPORTED = "UTF-8 not supported";

    public static Cookie createCookie(String name, String value,
            int maxage, String domain, String path, boolean secure,
            String comment, int version, boolean httpOnly) {

        // ensure that name is not null or empty
        if ((name == null) || (name.isEmpty())) {
            throw new IllegalArgumentException(INVALID_NAME);
        }

        // ensure that the value is not null and encode it
        try {
            if (value != null) {
                value = URLEncoder.encode(value, UTF_8.name());
            }
        } catch (UnsupportedEncodingException ex) {
            throw new UnsupportedOperationException(UTF8_UNSUPPORTED, ex);
        }

        // create the cookie
        Cookie cookie = new Cookie(name, value);

        // set the domain (Chrome doesn't like localhost domain on cookies)
        if ((domain != null)
                && (!domain.isEmpty()) && (!domain.equals("localhost"))) {
            cookie.setDomain(domain);
        } else {
            try {
                URL url = new URL(getRequest().getRequestURL().toString());
                cookie.setDomain(url.getHost());
            } catch (MalformedURLException ex) {
                throw new IllegalArgumentException(ex);
            }
        }

        // set the path
        if ((path != null) && (!path.isEmpty())) {
            cookie.setPath(path);
        }

        // set the secure
        if (secure) {
            cookie.setSecure(true);
        } else {
            cookie.setSecure(getRequest().isSecure());
        }

        // set httpOnly (recommended true)
        cookie.setHttpOnly(httpOnly);

        // set version
        if (version >= 0) {
            cookie.setVersion(version);
        }

        // set the comment
        if ((comment != null) && (!comment.isEmpty())) {
            cookie.setComment(comment);
        }

        // set the expiration time
        cookie.setMaxAge(maxage);

        return cookie;
    }

    public static void setCookieInstance(Cookie cookie) {
        if (cookie != null) {
            getResponse().addCookie(cookie);
        }
    }

    private static HttpServletRequest getRequest() {
        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        HttpServletRequest httpRequest = (HttpServletRequest) externalContext.getRequest();

        return httpRequest;
    }

    private static HttpServletResponse getResponse() {
        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        HttpServletResponse httpResponse = (HttpServletResponse) externalContext.getResponse();
        return httpResponse;
    }

}
