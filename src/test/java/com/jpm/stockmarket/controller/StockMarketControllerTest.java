package com.jpm.stockmarket.controller;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jpm.stockmarket.common.model.ResultCode;
import com.jpm.stockmarket.trade.model.StockTradeRequest;
import com.jpm.stockmarket.trade.model.TradeType;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class StockMarketControllerTest {
	private static ObjectMapper mapper = new ObjectMapper();

    @Autowired
    private MockMvc mvc;

    
    
    @Test
    public void getGBCE() throws Exception {
    	postTrade("POP", 10l, 10.0);
    	
    	postTrade("POP", 20l, 20.0);
    	
    	postTrade("TEA", 20l, 15.0);
    	
    	postTrade("GIN", 20l, 12.0);
    	
        mvc.perform(MockMvcRequestBuilders.get("/exchange/gbce").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.gbce").value(equalTo(13.774493079968597)));
    }
    
    private void postTrade(String symbol, Long shareQuantity, Double tradePrice) throws Exception{
    	
        StockTradeRequest request = new StockTradeRequest();
        request.setSharesQuantity(shareQuantity);
        request.setSymbol(symbol);
        request.setTradePrice(tradePrice);
        request.setType(TradeType.Buy);
        
     	mvc.perform(
                 post("/exchange/trade")
                 .contentType(MediaType.APPLICATION_JSON)
     			.content(mapper.writeValueAsString(request))
             )
                 .andExpect(status().isOk())
                 .andExpect(jsonPath("$.code").value(equalTo(ResultCode.SUCCESS.getCode())))
                 .andExpect(jsonPath("$.message").value(equalTo(ResultCode.SUCCESS.getMessage())));
    }
}
