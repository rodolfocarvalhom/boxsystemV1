package br.com.boxsystemV1.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.boxsystemV1.model.Uf;
import br.com.boxsystemV1.service.UfService;

@Component(value="ufConverter")
public class UfConverter implements Converter{

	@Autowired
	UfService ufServ;
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		try{
			if (value != ""){
				Uf uf = ufServ.buscarId(Integer.parseInt(value));
				return uf;
			}else{
				return null;
			}
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		try{
			//if ((!objPerfil.toString().isEmpty())){
			//Alterado a comparação de vazio para se o objeto pertence a familia objeto PERFIL
			if(value instanceof Uf){
				Uf uf = (Uf) value;
				return uf.getId().toString();			
			}else{
				return null;
			}
		}catch (Exception e) {
			return null;
		}
	}

}
