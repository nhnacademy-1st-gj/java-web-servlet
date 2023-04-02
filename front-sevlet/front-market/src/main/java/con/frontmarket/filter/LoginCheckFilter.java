package con.frontmarket.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Objects;

@WebFilter(filterName = "loginCheckFilter", urlPatterns = "/cartView.jsp")
public class LoginCheckFilter implements Filter {

  @Override
  public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
    HttpSession session = ((HttpServletRequest) servletRequest).getSession();
    Object id = session.getAttribute("id");

    if (Objects.isNull(id)) {
      ((HttpServletResponse) servletResponse).sendRedirect("/loginForm.jsp");
    } else {
      filterChain.doFilter(servletRequest, servletResponse);
    }
  }
}
