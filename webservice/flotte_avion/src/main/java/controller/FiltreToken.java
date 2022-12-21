// package controller;

// import com.fasterxml.jackson.databind.ObjectMapper;
// import connexion.Connexion;
// import exception.NullException;
// import exception.ShowError;
// import mapping.TokenUtilisateur;
// import org.springframework.core.annotation.Order;
// import org.springframework.stereotype.Component;

// import javax.servlet.*;
// import javax.servlet.http.HttpServlet;
// import javax.servlet.http.HttpServletRequest;
// import javax.servlet.http.HttpServletResponse;
// import javax.swing.plaf.TabbedPaneUI;
// import java.io.IOException;
// import java.io.PrintWriter;
// import java.sql.Connection;

// @Component
// @Order(1)
// public class FiltreToken implements Filter {
// @Override
// public void init(FilterConfig filterConfig) throws ServletException {
// Filter.super.init(filterConfig);
// }

// public String convertToJson(Object ob) throws Exception {
// if (ob == null) {
// return null;
// }
// ObjectMapper mapper = new ObjectMapper();
// return mapper.writeValueAsString(ob);
// }

// @Override
// public void doFilter(ServletRequest request, ServletResponse response,
// FilterChain chain)
// throws IOException, ServletException {
// HttpServletRequest servletRequest = (HttpServletRequest) request;
// HttpServletResponse servletResponse = (HttpServletResponse) response;
// servletResponse.setHeader("Access-Control-Allow-Origin", "*");
// servletResponse.setHeader("Access-Control-Allow-Methods", "GET, POST ,PUT,
// DELETE, OPTIONS");
// servletResponse.setHeader("Access-Control-Max-Age", "3600");
// servletResponse.setHeader("Access-Control-Allow-Headers", "authorization,
// content-type, xsrf-token");
// servletResponse.addHeader("Access-Control-Expose-Headers", "xsrf-token");
// if ((servletRequest.getRequestURI().startsWith("/trajet"))) {
// String token = servletRequest.getParameter("token");
// int id = Integer.parseInt(servletRequest.getParameter("id"));
// System.out.println("token" + id);

// TokenUtilisateur tokenuser = new TokenUtilisateur(token, id);
// Connection co = new Connexion().getConnection();
// try {
// tokenuser = tokenuser.checkIfExpire(co);
// if (tokenuser == null) {
// servletResponse.getWriter()
// .write(convertToJson(new ShowError(new NullException(409, "Token expire"))));
// } else {
// chain.doFilter(request, response);
// }

// co.close();
// } catch (Exception e) {
// throw new RuntimeException(e);

// }
// } else {
// chain.doFilter(request, response);
// }

// // doFilter(request,response,chain);
// }

// @Override
// public void destroy() {
// Filter.super.destroy();
// }
// }
