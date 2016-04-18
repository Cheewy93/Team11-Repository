package convertors;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import beans.BookManagedBean;
import model.Category;

@FacesConverter("categoryConverter")
public class CategoryConverter implements Converter {

	public CategoryConverter() {
	}

	@Override
	public Object getAsObject(FacesContext context, UIComponent arg1,
			String arg2) {
		BookManagedBean bmb = context.getApplication()
				.evaluateExpressionGet(context, "#{bookManagedBean}",
						BookManagedBean.class);

		for (Category cat : bmb.getCategories()) {
			if (String.valueOf(cat.getCategoryId()).equals(arg2))
				return cat;
		}
		throw new ConverterException(new FacesMessage(
				String.format("Cannot convert " + arg2 + " to sales unit")));
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
		if (arg2 != null) {

			Category cat = (Category) arg2;
			return String.valueOf(cat.getCategoryId());

		} else {
			return "";
		}

	}

}
