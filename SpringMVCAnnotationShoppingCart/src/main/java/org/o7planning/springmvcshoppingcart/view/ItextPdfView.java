package org.o7planning.springmvcshoppingcart.view;


import java.text.DateFormat;
import java.util.List;
import java.util.Map;

import javax.persistence.criteria.Order;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.o7planning.springmvcshoppingcart.entity.OrderDetail;
import org.o7planning.springmvcshoppingcart.model.CartInfo;
import org.o7planning.springmvcshoppingcart.model.CartLineInfo;
import org.o7planning.springmvcshoppingcart.util.Utils;

import com.itextpdf.text.Document;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class ItextPdfView extends AbstractITextPdfView {

    private static final DateFormat DATE_FORMAT = DateFormat.getDateInstance(DateFormat.SHORT);

    @Override
    protected void buildPdfDocument(Map<String, Object> model,
                                    Document document, PdfWriter writer, HttpServletRequest request,
                                    HttpServletResponse response) throws Exception {

        @SuppressWarnings("unchecked")
//      List<CartInfo> courses = (List<Course>) model.get("courses");
        CartInfo cartInfo = Utils.getCartInSession(request); 

        PdfPTable table = new PdfPTable(3);
        table.setWidths(new int[]{20, 50, 30});
        

        table.addCell("Nombre Cliente");
        table.addCell("Producto");
        table.addCell("Unidades");
        
//        table.addCell(String.valueOf(OrderDetail));
    
//        table.addCell(String.valueOf(cartInfo.getOrderNum()));
//        table.addCell(String.valueOf(cartInfo.getAmountTotal()));
//        table.addCell(String.valueOf(cartInfo.getCustomerInfo().getEmail()));

        for (CartLineInfo carritoinfo: cartInfo.getCartLines() ){
        	table.addCell(String.valueOf(cartInfo.getOrderNum()));
            table.addCell(String.valueOf(cartInfo.getAmountTotal()));
            table.addCell(String.valueOf(cartInfo.getCustomerInfo().getEmail()));
        }

        


        document.add(table);
    }

}