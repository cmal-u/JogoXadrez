 


/**
 * Write a description of class Cavalo here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Cavalo extends Peca
{
    
    /**
     * Constructor for objects of class Cavalo
     */
    public Cavalo(Casa casa, int tipo, Tabuleiro tabuleiro)
    {
      super(casa, tipo, tabuleiro);
    }
    
    public void mover(Casa destino) {
        if (podeMover(destino)) {
            casa.removerPeca();
            destino.colocarPeca(this);
            casa = destino;
        }
    }
     
    public boolean podeMover(Casa destino) {
        
        // dentro do if vai verificar se o destino possui peca e se possuir o movimento so sera valido se o tipo for diferente do tipo da casa
        if (((tipo == 4 || tipo == 5)  && (destino.possuiPeca() == false ||  capturar(destino) == true)) &&
            ((casa.getX()+2 == destino.getX() || casa.getX()-2 == destino.getX()) &&
                (casa.getY()+1 == destino.getY() || casa.getY()-1 == destino.getY()))){
                moveuDuasCasas = false;
                return true;
                
        } else if (((tipo == 4 || tipo == 5) && (destino.possuiPeca() == false ||  capturar(destino) == true)) &&
           ((casa.getX()+1 == destino.getX() || casa.getX()-1 == destino.getX()) && 
                (casa.getY()+2 == destino.getY() || casa.getY()-2 == destino.getY()))){
                moveuDuasCasas = false;
                return true;
        }
        
        return false;    
    }
}
