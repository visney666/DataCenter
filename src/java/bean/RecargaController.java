package bean;

import model.Recarga;
import bean.util.JsfUtil;
import bean.util.JsfUtil.PersistAction;
import session.RecargaFacade;

import java.io.Serializable;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@Named("recargaController")
@SessionScoped
public class RecargaController implements Serializable {

    @EJB
    private session.RecargaFacade ejbFacade;
    private List<Recarga> items = null;
    private Recarga selected;

    public RecargaController() {
    }

    public Recarga getSelected() {
        return selected;
    }

    public void setSelected(Recarga selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
        selected.getRecargaPK().setOperadorId(selected.getOperador().getOperadorId());
        selected.getRecargaPK().setVendedorId(selected.getVendedor().getVendedorId());
    }

    protected void initializeEmbeddableKey() {
        selected.setRecargaPK(new model.RecargaPK());
    }

    private RecargaFacade getFacade() {
        return ejbFacade;
    }

    public Recarga prepareCreate() {
        selected = new Recarga();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("RecargaCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("RecargaUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("RecargaDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<Recarga> getItems() {
        if (items == null) {
            items = getFacade().findAll();
        }
        return items;
    }

    private void persist(PersistAction persistAction, String successMessage) {
        if (selected != null) {
            setEmbeddableKeys();
            try {
                if (persistAction != PersistAction.DELETE) {
                    getFacade().edit(selected);
                } else {
                    getFacade().remove(selected);
                }
                JsfUtil.addSuccessMessage(successMessage);
            } catch (EJBException ex) {
                String msg = "";
                Throwable cause = ex.getCause();
                if (cause != null) {
                    msg = cause.getLocalizedMessage();
                }
                if (msg.length() > 0) {
                    JsfUtil.addErrorMessage(msg);
                } else {
                    JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
                }
            } catch (Exception ex) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
                JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            }
        }
    }

    public Recarga getRecarga(model.RecargaPK id) {
        return getFacade().find(id);
    }

    public List<Recarga> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<Recarga> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = Recarga.class)
    public static class RecargaControllerConverter implements Converter {

        private static final String SEPARATOR = "#";
        private static final String SEPARATOR_ESCAPED = "\\#";

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            RecargaController controller = (RecargaController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "recargaController");
            return controller.getRecarga(getKey(value));
        }

        model.RecargaPK getKey(String value) {
            model.RecargaPK key;
            String values[] = value.split(SEPARATOR_ESCAPED);
            key = new model.RecargaPK();
            key.setIdRecarga(Integer.parseInt(values[0]));
            key.setVendedorId(Integer.parseInt(values[1]));
            key.setOperadorId(Integer.parseInt(values[2]));
            return key;
        }

        String getStringKey(model.RecargaPK value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value.getIdRecarga());
            sb.append(SEPARATOR);
            sb.append(value.getVendedorId());
            sb.append(SEPARATOR);
            sb.append(value.getOperadorId());
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof Recarga) {
                Recarga o = (Recarga) object;
                return getStringKey(o.getRecargaPK());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Recarga.class.getName()});
                return null;
            }
        }

    }

}
