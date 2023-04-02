package con.frontmarket;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
public class LanguageController implements Command {
  @Override
  public String execute(HttpServletRequest req, HttpServletResponse resp) throws IOException {
    String language = req.getParameter("language");

    req.getSession().setAttribute("language",language);
    return "redirect:/index.jsp";
  }
}
