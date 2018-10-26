import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.*;
/**
 * Representa uma Pe�a do jogo.
 * Possui uma casa e um tipo associado.
 * 
 * @author Alan Moraes &lt;alan@ci.ufpb.br&gt;
 * @author Leonardo Villeth &lt;lvilleth@cc.ci.ufpb.br&gt;
 */
public class Peca {
    //peças brancas serao pares
    //peças pretas serao impares
    public static final int PEAO_BRANCO = 0;
    public static final int TORRE_BRANCA = 2;
    public static final int CAVALO_BRANCO = 4;
    public static final int BISPO_BRANCO = 6;
    public static final int RAINHA_BRANCA = 8;
    public static final int REI_BRANCO = 10;
    public static final int PEAO_PRETO = 1;
    public static final int TORRE_PRETA = 3;
    public static final int CAVALO_PRETO = 5;
    public static final int BISPO_PRETO = 7;
    public static final int RAINHA_PRETA = 9;
    public static final int REI_PRETO = 11;


    protected Casa casa;
    protected int tipo;
    protected Tabuleiro tabuleiro;
    protected boolean moveuDuasCasas;
    public Peca(Casa casa, int tipo, Tabuleiro tabuleiro) {
        this.casa = casa;    
        this.tipo = tipo;
        casa.colocarPeca(this);
        this.tabuleiro = tabuleiro;
        moveuDuasCasas = false;
    }
        
    /**
     * Movimenta a peca para uma nova casa.
     * @param destino nova casa que ira conter esta peca.
     */
    public void mover(Casa destino) {
        if (podeMover(destino)) {
            casa.removerPeca();
            destino.colocarPeca(this);
            casa = destino; 

        }
    }
   
    public boolean capturar(Casa destino){
        //nao pode matar o rei
        if ((casa.getTipoPeca()%2 != 0 && destino.getTipoPeca() == 10) || (casa.getTipoPeca()%2 == 0 && destino.getTipoPeca() == 11)){
            JOptionPane.showMessageDialog(null, " Xeque");
            return false;
        }
        
        //verifica os tipos das peças
        if(casa.getTipoPeca()%2 == 0 && destino.getTipoPeca()%2 != 0){
            return true;
        }
        else if(casa.getTipoPeca()%2 != 0 && destino.getTipoPeca()%2 == 0){
            return true;
        }
        else if(casa.getTipoPeca()%2 == 0 && destino.getTipoPeca()%2 == 0){
            return false;
        }
        else if(casa.getTipoPeca()%2 != 0 && destino.getTipoPeca()%2 != 0){
            return false; 
        }
        return false;
     }        
      
       
    public boolean podeMover(Casa destino){
        return false;
    }
     
    public int getDistancia(int i){
        if(i < 0){
            return -i;
        }
        return i;
    } 
    
    public boolean roqueTorre(Casa destino){
        return false;
    }
    
    public boolean roqueRei(Casa destino){
         return false;
    }
    
    public boolean roque(Casa destino){
        if(roqueTorre(destino) == true && roqueRei(destino) == true){
            roqueTorre(destino);
            roqueRei(destino);
            return true;
        }
        return false;
    }
     
    
    /**
     * Valor    Tipo
     *   0   Branca (Peao)
     *   1   Preta (Peao)
     *   2   Branca (Torre)
     *   3   Preta (Torre)
     *   4   Branca (Cavalo)
     *   5   Preta (Cavalo)
     *   6   Branca (Bispo)
     *   7   Preta (Bispo)
     *   8   Branca (Dama)
     *   9   Preta (Dama)
     *   10  Branca (Rei)
     *   11  Preta (Rei)
     *   
     *   
     * @return o tipo da peca.
     */
    public int getTipo() {
        return tipo;
    }
}
