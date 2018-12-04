/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xadrez.fontes;

import java.awt.Font;
import java.io.InputStream;

/**
 *
 * @author Jander
 */
public class Fontes {
    
    private Font fonte = null;
    public String caveirada = "vtkscaveirada.ttf";
    public String skulls = "Designers Skulls.TTF";
    public String doubleFeature = "DoubleFeature20.ttf";
    public String Sketch = "KGBlankSpaceSketch.ttf";
    
    public Font GetFonte(String fonteNome, int estilo, float tamanho){
        
        try{
            //Carregar a fonte.
            InputStream is = getClass().getResourceAsStream(fonteNome);
            fonte = Font.createFont(Font.TRUETYPE_FONT, is);
        } catch (Exception ex){
            // se der erro ao carregar a fonte.
            System.err.println(fonteNome +"Fonte não carregada");
            fonte = new Font("ARIAL", Font.PLAIN, 10);
        }
        Font tp_fonte = fonte.deriveFont(estilo, tamanho);
        return tp_fonte;
    }
}
