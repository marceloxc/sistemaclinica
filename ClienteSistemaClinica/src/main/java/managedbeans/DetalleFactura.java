/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package managedbeans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIOutput;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.component.html.HtmlPanelGrid;
import javax.faces.component.html.HtmlSelectOneMenu;
import org.primefaces.component.column.Column;

/**
 *
 * @author karina
 */
@ManagedBean(name="DetalleFactura")
@SessionScoped
public class DetalleFactura {
    private HtmlPanelGrid panel;
    /**
     * Creates a new instance of DetalleFactura
     */
    public DetalleFactura() {
        panel= new HtmlPanelGrid();
        panel.setColumns(4);
        
        HtmlInputText texto= new HtmlInputText();
        texto.setStyle("width: 110px!important");
        HtmlSelectOneMenu serv = new HtmlSelectOneMenu();        
        serv.setStyle("width: 200px!important");
        HtmlOutputLabel pu = new HtmlOutputLabel();
        HtmlOutputLabel tot = new HtmlOutputLabel();
        
        HtmlOutputLabel tcant = new HtmlOutputLabel();
        tcant.setValue("Cantidad");
        HtmlOutputLabel tdesc = new HtmlOutputLabel();
        tcant.setValue("Descripcion");
        HtmlOutputLabel tpunit = new HtmlOutputLabel();
        tcant.setValue("P. Unitario");
        HtmlOutputLabel ttot = new HtmlOutputLabel();
        tcant.setValue("Total");
        
        Column c = new Column();
        UIOutput salida= new UIOutput();
        salida.setValue("Cantidad");
        c.getFacets().put("header", salida);
        panel.getChildren().add(c);
        
        panel.getChildren().add(texto);
        panel.getChildren().add(serv);
        panel.getChildren().add(pu);
        panel.getChildren().add(tot);
        
        HtmlPanelGrid panel2 = new HtmlPanelGrid();
        panel2.setColumns(4);
        panel2.getChildren().add(tcant);
        panel2.getChildren().add(tdesc);
        panel2.getChildren().add(tpunit);
        panel2.getChildren().add(ttot);
        
        panel.getFacets().put("header", panel2);
    }

    public HtmlPanelGrid getPanel() {
        return panel;
    }

    public void setPanel(HtmlPanelGrid panel) {
        this.panel = panel;
    }
    
    
}
