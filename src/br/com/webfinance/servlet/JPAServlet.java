package br.com.webfinance.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class JPAServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		PrintWriter out = resp.getWriter();
		
		String jpql = req.getParameter("jpql");
		
		out.println("<!DOCTYPE HTML>");
		out.println("<html>");
		out.println("<body>");
		
		// formulário
		out.println("<form  method='POST' action='JPAServlet'>");
		out.print("  <textarea name='jpql' rows='4' cols='50'>");
		out.print(jpql);
		out.println("</textarea>");
		out.println("  <button type='submit'>OK</button>");
		out.println("</form>");
		
		if (jpql != null) {
			//processa(out, jpql);
		}
		
		out.println("</body>");
		out.println("</html>");
		
	}
	
	/*
	private void processa(PrintWriter out, String jpql) throws IOException {
		List<?> lista = service.executarConsulta(jpql, null);
		if (lista == null || lista.size() == 0) {
			out.println("<table border='1'><tr><td>Nenhum registro encontrado!</td></tr></table>");
			return;
		}

		try {
			out.println("<table border='1'>");

			BeanInfo binfo;
			binfo = Introspector.getBeanInfo(lista.get(0).getClass());
			PropertyDescriptor[] properties = binfo.getPropertyDescriptors();

			if (properties != null) {
				Method readMethod = null;
				Method writeMethod = null;

				out.println("<tr>");

				for (int i = 0; i < properties.length; i++) {
					readMethod = properties[i].getReadMethod();
					writeMethod = properties[i].getWriteMethod();

					if (readMethod != null && writeMethod != null) {
						out.print("<th>Testes");
						out.print(properties[i].getName());
						out.println("</th>");
					}
				}

				out.println("</tr>");

				for (Object objeto : lista) {

					out.println("<tr>");
					for (int i = 0; i < properties.length; i++) {
						readMethod = properties[i].getReadMethod();
						writeMethod = properties[i].getWriteMethod();

						if (readMethod != null && writeMethod != null) {

							Object obj = readMethod.invoke(objeto);
							out.print("<td>dados");
							if (obj != null) {
								out.print(obj.toString());

							}
							out.println("</td>");
						}
					}

					out.println("</tr>");
				}
			}

			out.println("</table>");
		} catch (IntrospectionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	*/
}
