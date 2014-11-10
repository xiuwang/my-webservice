package br.com.rafaelmurata.stock.ws;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.Stateless;
import javax.jws.*;

@WebService(targetNamespace="http://rafaelmurata.com.br/stock/v1")
@Stateless
public class StockWS {
	private Map<String, ItemStock> repo = new HashMap<>();

	public StockWS(){
		repo.put("SOA", new ItemStock("SOA",5));
		repo.put("WEB", new ItemStock("WEB",3));

	}
	@WebMethod
	public List<ItemStock> getListStock(
			@WebParam(name="cod") List<String> codes,
			@WebParam(name="tokenUser", header = true) String token){
		
		if(token == null || !token.equals("TOKEN123")){
			throw new AuthExeption("deny");
		}
		
		List<ItemStock> items = new ArrayList<>();
		
		if(codes == null || codes.isEmpty()){
			return items;
		}
		System.out.println("checking" + codes);
		
		for(String cod : codes){
			if(repo.containsKey(cod))
				items.add(repo.get(cod));
		}
		return items;
	}

}
