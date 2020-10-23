/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.bean;

/**
 *
 * @author William
 */
public class AlunoMedia extends Aluno {
    private float np1, np2, media;
    private int faltas;

    public float getNp1() {
        return np1;
    }

    public void setNp1(float np1) {
        this.np1 = np1;
    }

    public float getNp2() {
        return np2;
    }

    public void setNp2(float np2) {
        this.np2 = np2;
    }

    public float getMedia() {
        return media;
    }

    public void setMedia(float media) {
        this.media = media;
    }

    public int getFaltas() {
        return faltas;
    }

    public void setFaltas(int faltas) {
        this.faltas = faltas;
    }
    
}
