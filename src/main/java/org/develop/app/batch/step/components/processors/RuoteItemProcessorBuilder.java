package org.develop.app.batch.step.components.processors;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.codehaus.jettison.json.JSONObject;
import org.develop.app.batch.dto.RuotaDto;
import org.develop.app.batch.dto.interfaces.Dto;
import org.develop.app.batch.step.components.interfaces.ProcessorsInterface;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;


public class RuoteItemProcessorBuilder implements ProcessorsInterface<Dto, Dto> {

	private static final Logger log = LoggerFactory.getLogger(RuoteItemProcessorBuilder.class);
	
	@Override
	public ItemProcessor<Dto, Dto> build(JSONObject json) {		
		return new RuoteItemProcessor();
	}
	


	private class RuoteItemProcessor implements ItemProcessor<Dto, Dto> {
		
		private List<RuotaDto> ruoteList = new ArrayList<>();
		private HashMap<String,String> mapRuotaDesc = new HashMap<>();
		
		{
	        mapRuotaDesc.put("BA","Bari");
	        mapRuotaDesc.put("FI","Firenze");
	        mapRuotaDesc.put("MI","Milano");
	        mapRuotaDesc.put("NA","Napoli");
	        mapRuotaDesc.put("PA","Palermo");
	        mapRuotaDesc.put("RM","Roma");
	        mapRuotaDesc.put("TO","Torino");
	        mapRuotaDesc.put("VE","Venezia");
	        mapRuotaDesc.put("CA","Cagliari");
	        mapRuotaDesc.put("GE","Genova");
	        mapRuotaDesc.put("RN","Ruota nazionale");
			
		}
		
		@Override
		public RuotaDto process(Dto in) throws Exception {
	
			RuotaDto item = (RuotaDto) in;
			
			if(log.isInfoEnabled()) {
				log.info("Processing..." + item);
			}
			
			RuotaDto ruota = new RuotaDto();
		
			ruota.setPrimoUtilizzo(item.getPrimoUtilizzo());
			ruota.setDescrizioneBreve(item.getDescrizioneBreve());
			ruota.setDescrizione(mapRuotaDesc.get(item.getDescrizioneBreve()));	
			
			return ruota;
		}
		
	}
}