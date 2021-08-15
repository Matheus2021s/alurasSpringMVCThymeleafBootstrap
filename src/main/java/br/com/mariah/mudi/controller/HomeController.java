package br.com.mariah.mudi.controller;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import br.com.mariah.mudi.model.Pedido;

@Controller
public class HomeController {

	@GetMapping("/home")
	public String home(Model model) {
		Pedido pedido = new Pedido();
		pedido.setNomeProduto("Casio Casiotone, 61-Key Portable Keyboard with USB, RED (CT-S200RD)");
		pedido.setUrlImagem("https://m.media-amazon.com/images/I/61CdMH9ZW7L._AC_SL1024_.jpg");
		pedido.setValorNegociado(new BigDecimal(119));
		pedido.setDataEntrega(LocalDate.now());
		pedido.setUrlProduto(
				"https://www.amazon.com/Casio-Casiotone-Portable-Keyboard-CT-S200RD/dp/B07VSTXH3V/ref=sr_1_2?dchild=1&keywords=teclado+casio+ct+-s195&qid=1628999118&sr=8-2");
		pedido.setDescricao(
				"Casio proudly presents the next generation of Casio tone keyboards. "
				+ "Featuring 400 tones and 75 rhythms, the Casio tone ct-s200 is the perfect first step, "
				+ "The perfect gift, and the perfect way to have fun making music. "
				+ "The ct-s200 also lets you express your style as it is available in either black, "
				+ "white or RED. The ultra-compact ct-s200 lets you make music wherever and whenever you want. "
				+ "Just pop in six AA batteries, grab the built-in carrying handle and take your inspiration to go."
				+ " The ct-s200 also includes the power supply and music rest. Explore a variety of "
				+ "great sounding tones and accompaniment rhythms with 61 full-size keys, an easy-to-read "
				+ "LCD display and intuitive controls. Use the \"My setup\" Function to quickly get to your favorite sounds. "
				+ "Dance music Mode lets you easily create and remix EDM tracks. Select a style, and use the keys to trigger"
				+ " drum loops, bassline, synth parts, effects, transitions and more. Use the built-in speakers to share with "
				+ "friends, or plug in headphones for quiet play At any time. The 1/8\" Audio input lets you play along with music"
				+ " from your favorite device. Connect to the free Chordata play iOS/Android app And take your music further, "
				+ "learning how to play your favorite songs from downloaded MIDI files. The class-compliant USB port connects t"
				+ "o any Mac/PC/iOS/Android device with no drivers needed.");
		
		List<Pedido> pedidos = Arrays.asList(pedido);
		model.addAttribute("pedidos", pedidos);
		return "home";
	}
}
