package com.example.reCapProject.entities.request.update;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateCreditCardRequest {
		
	private int customerId;
	
	@NotNull
	@NotBlank(message="Kart adını giriniz")
	private String cardName;
	
	@NotNull
	@NotBlank(message="Kart numaranızı giriniz.")
	private String cardNumber;
	
	@NotNull
	@NotBlank (message="Kartınızın arkasında bulunan 3 haneli cvc numarasını giriniz.")
	private String cvc;
	
	private int cardId;

}
