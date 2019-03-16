//Main Servlet

package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.InputValues;
import domain.OutputValues;

@WebServlet("/calculator")
public class MainServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		String kwotaKredytu = request.getParameter("kwota");
		String iloscRat = request.getParameter("iloscrat");
		String oprocentowanie = request.getParameter("oprocentowanie");
		String oplataStala = request.getParameter("oplatastala");
		String rodzajRat = request.getParameter("rodzajrat");
		InputValues dane = new InputValues();
		List<OutputValues> lista = new ArrayList<OutputValues>();
		
		if (kwotaKredytu == null || kwotaKredytu.equals("") || iloscRat == null || iloscRat.equals("") || oprocentowanie == null || oprocentowanie.equals("") || oplataStala == null|| oplataStala.equals("")) {
			response.sendRedirect("/");
		}
		dane = CreditCalculator.ParseValues(kwotaKredytu, iloscRat, oprocentowanie, oplataStala, rodzajRat);
		response.setContentType("text/html");

		if (dane.getRodzajRat().equals("stala")) {
			lista = CreditCalculator.stalaRata(dane, lista);
			response.getWriter().print(CreditCalculator.printTable(lista, dane));

		} else {
			lista = CreditCalculator.malejacaRata(dane, lista);
			response.getWriter().print(CreditCalculator.printTable(lista, dane));
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		String kwotaKredytu = request.getParameter("kwotakredytu");
		String iloscRat = request.getParameter("iloscrat");
		String oprocentowanie = request.getParameter("oprocentowanie");
		String oplataStala = request.getParameter("oplatastala");
		String rodzajRat = request.getParameter("rodzajrat");
		InputValues dane = new InputValues();
		List<OutputValues> lista = new ArrayList<OutputValues>();

		if (kwotaKredytu == null || kwotaKredytu.equals("") || iloscRat == null || iloscRat.equals("") || oprocentowanie == null || oprocentowanie.equals("") || oplataStala == null || oplataStala.equals("")) {
			response.sendRedirect("/");
		}
		dane = CreditCalculator.ParseValues(kwotaKredytu, iloscRat, oprocentowanie, oplataStala, rodzajRat);
		response.setContentType("text/html");

		if (dane.getRodzajRat().equals("stala")) {
			lista = CreditCalculator.stalaRata(dane, lista);
			response.getWriter().print(CreditCalculator.printTable(lista, dane));

		} else {
			lista = CreditCalculator.malejacaRata(dane, lista);
			response.getWriter().print(CreditCalculator.printTable(lista, dane));

		}
	}

}
