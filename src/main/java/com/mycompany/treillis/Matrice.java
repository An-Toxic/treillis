package com.mycompany.treillis;

import java.lang.Math;

public class Matrice {

    int nbrLig, nbrCol;
    double[][] coeffs;

    //attribut
    public Matrice(int ligne, int colonne) {
        //constructor
        //we can remove the "this"
        this.nbrLig = ligne;
        this.nbrCol = colonne;
        this.coeffs = new double[nbrLig][nbrCol];
        for (int i = 0; i < nbrLig; i++) {
            for (int j = 0; j < nbrCol; j++) {
                coeffs[i][j] = 0;
            }
        }
    }

    public static Matrice identite(int n) {
        Matrice nouv = new Matrice(n, n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    nouv.coeffs[i][j] = 1;
                } else {
                    nouv.coeffs[i][j] = 0;
                }
            }

        }
        return nouv;
    }

    public static Matrice matTest1(int n) {
        Matrice m1 = new Matrice(n, n);
        int k = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                m1.coeffs[i][j] = k;
                k = k + 1;
            }
        }
        return m1;
    }

    public static Matrice matTest2(int n) {
        Matrice m2 = new Matrice(n, n);
        int f = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    m2.coeffs[i][j] = -f++;
                } else {
                    m2.coeffs[i][j] = f++;
                }
            }
        }
        return m2;

    }

    public static int aleaUnouDeux() {
        double x = Math.random();
        if (x <= 0.5) {
            return 1;
        } else {
            return 2;
        }
    }

    public static Matrice matAleaZeroUnDeux(int nl, int nc, double p) {
        Matrice m3 = new Matrice(nl, nc);
        for (int i = 0; i < nl; i++) {
            for (int j = 0; j < nc; j++) {
                if (Math.random() <= p) {
                    m3.coeffs[i][j] = 0;
                } else {
                    m3.coeffs[i][j] = aleaUnouDeux();
                }
            }
        }
        return m3;
    }

    public static Matrice creeVecteur(double[] tab) {
        Matrice m4 = new Matrice(tab.length, 1);
        for (int i = 0; i < tab.length; i++) {
            m4.coeffs[i][0] = tab[i];
        }
        return m4;

    }

    public double getcoeffs(int i, int j) {
        return this.coeffs[i][j];
    }

    public void set(int i, int j, double x) {
        this.coeffs[i][j] = x;
        System.out.println(this.coeffs[i][j]);
    }

    public static void test1() {
        Matrice m8 = new Matrice(4, 6).matAleaZeroUnDeux(4, 6, 0.33);
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 6; j++) {
                System.out.print(m8.coeffs[i][j] + " ");
            }
            System.out.println(" ");
        }
    }

    //affichage de Matrice sous forme de String
    public String toString() {
        String s;
        s = "";
        for (int i = 0; i < this.nbrLig; i++) {
            s = s + "[";
            for (int j = 0; j < this.nbrCol; j++) {
                s = s + String.format("%+4.2E", this.coeffs[i][j]);
                if (j != this.nbrCol - 1) {
                    s = s + " ";
                }
            }
            s = s + "]\n";
        }
        return s;
    }

    public Matrice concatLig(Matrice N) {
        if (this.nbrCol == N.nbrCol) {
            Matrice R = new Matrice(this.nbrLig + N.nbrLig, this.nbrCol);
            for (int i = 0; i < R.nbrLig; i++) {
                for (int j = 0; j < R.nbrCol; j++) {

                    if (i < this.nbrLig) {
                        R.coeffs[i][j] = this.coeffs[i][j];
                    } else {
                        R.coeffs[i][j] = N.coeffs[i - this.nbrLig][j];
                    }
                }
            }
            return R;
        } else {
            throw new Error("Matrices non compatibles");
        }
    }

    public Matrice concatCol(Matrice N) {
        if (this.nbrLig == N.nbrLig) {
            Matrice R = new Matrice(this.nbrLig, this.nbrCol + N.nbrCol);
            for (int i = 0; i < R.nbrLig; i++) {
                for (int j = 0; j < R.nbrCol; j++) {

                    if (j < this.nbrCol) {
                        R.coeffs[i][j] = this.coeffs[i][j];
                    } else {
                        R.coeffs[i][j] = N.coeffs[i][j - this.nbrCol];
                    }
                }
            }
            return R;
        } else {
            throw new Error("Matrice non compatibles ");
        }
    }

    public Matrice subLignes(Matrice M, int nMin, int nMax) {
        if (nMin <= nMax && nMax <= M.nbrLig) {
            Matrice R = new Matrice(nMax - nMin + 1, M.nbrCol);
            for (int i = 0; i < R.nbrLig; i++) {
                for (int j = 0; j < R.nbrCol; j++) {
                    R.coeffs[i][j] = M.coeffs[nMin + i][j];
                }
            }
            return R;
        } else {
            throw new Error("Erreur de valeurs des entiers ");
        }
    }

    public Matrice subCols(int nMin, int nMax) {
        if (nMin <= nMax && nMax <= this.nbrCol) {
            Matrice R = new Matrice(this.nbrLig, nMax - nMin + 1);
            for (int i = 0; i < R.nbrLig; i++) {
                for (int j = 0; j < R.nbrCol; j++) {
                    R.coeffs[i][j] = this.coeffs[i][nMin + j];
                }
            }
            return R;
        } else {
            throw new Error("Erreur de valeurs des entiers ");
        }
    }

    public Matrice transposee() {
        Matrice T = new Matrice(this.nbrCol, this.nbrLig);
        for (int i = 0; i < T.nbrLig; i++) {
            for (int j = 0; j < T.nbrCol; j++) {
                T.coeffs[i][j] = this.coeffs[j][i];
            }
        }
        return T;
    }

    public Matrice metAucarre() {
        Matrice idn = identite(this.nbrLig);
        Matrice idc = identite(this.nbrCol);
        Matrice Mt = this.transposee();
        Matrice R;
        //new Matrice(this.nbrCol+this.nbrLig , this.nbrCol+ this.nbrLig);
        Matrice R1;
        Matrice R2;
        R1 = this.concatLig(idn);
        R2 = idc.concatLig(Mt);
        R = R1.concatCol(R2);
        return R;

    }

    public static Matrice add(Matrice m1, Matrice m2) {

        if (m1.nbrLig == m2.nbrLig && m1.nbrCol == m2.nbrCol) {
            Matrice R = new Matrice(m1.nbrLig, m1.nbrCol);
            for (int i = 0; i < R.nbrLig; i++) {
                for (int j = 0; j < R.nbrCol; j++) {
                    R.coeffs[i][j] = m1.coeffs[i][j] + m2.coeffs[i][j];

                }
            }

            return R;
        } else {
            throw new Error("Matrice non incompatibles");

        }
    }

    public Matrice opp() {
        Matrice R = new Matrice(this.nbrLig, this.nbrCol);
        for (int i = 0; i < R.nbrLig; i++) {
            for (int j = 0; j < R.nbrCol; j++) {
                R.coeffs[i][j] = -this.coeffs[i][j];
            }
        }
        return R;
    }

    public static Matrice moins(Matrice m1, Matrice m2) {
        if (m1.nbrCol == m2.nbrCol && m1.nbrLig == m2.nbrLig) {
            Matrice R = new Matrice(m1.nbrLig, m1.nbrCol);
            R = add(m1, m2.opp());
            return R;
        } else {
            throw new Error("Matrices incompatibles");
        }
    }

    public static Matrice mult(Matrice m1, Matrice m2) {
        if (m1.nbrCol == m2.nbrLig) {
            Matrice m = new Matrice(m1.nbrLig, m2.nbrCol);
            for (int i = 0; i < m.nbrLig; i++) {
                for (int j = 0; j < m.nbrCol; j++) {
                    for (int k = 0; k < m.nbrLig; k++) {
                        m.coeffs[i][j] += m1.coeffs[i][k] * m2.coeffs[k][j];
                    }
                }
            }
            return m;
        } else {
            throw new Error("Matrice incompatibles");
        }
    }

    public int permuteLigne(int a, int b) {
        int k = 0;
        for (int j = 0; j < this.nbrCol; j++) {
            double c = this.coeffs[a][j];
            this.coeffs[a][j] = this.coeffs[b][j];
            this.coeffs[b][j] = c;

            if (this.coeffs[a][j] != this.coeffs[b][j]) {
                k = k + 1;
            }
        }
        if (k == 0) {
            return 1;
        } else {
            return -1;

        }
    }
    //annule les coefficients en prenant un pivot M(e,e)

    public void transvection(int a, int b) {
       if (a < this.nbrCol) {
            if (this.coeffs[a][a] != 0) {
                double p = this.coeffs[b][a] / this.coeffs[a][a];
                for (int j = 0; j < this.nbrCol; j++) {
                    /*if (j == a) {
                        this.coeffs[b][j] = 0;
                    } else { */
                        this.coeffs[b][j] = this.coeffs[b][j] - p * this.coeffs[a][j];
                    }

                
            } /*else {
                throw new Error("le pivot ne peut pas etre un zero");

            }*/
       } else {
            throw new Error("le nombre a saisie est plus grand que le nombre de colonne de la matrice ");

        }

    }

    public int lignePlusGrandPivot(int e) {
        int imax = e;
        int k = 0;
        double EPSILON_PIVOT = 1 / (10 * 10 * 10 * 10 * 10 * 10 * 10 * 10);
        if (e < this.nbrLig && e < this.nbrLig) {
            for (int i = e; i < this.nbrLig; i++) {
                if (this.coeffs[i][e] == 0) {
                    k = k + 1;
                }
            }
            if (k == this.nbrLig - e) {
                return -1;
            } else {
                for (int i = e + 1; i < this.nbrLig; i++) {

                    if (Math.abs(this.coeffs[i][e]) > Math.abs(this.coeffs[imax][e])) {
                        imax = i;
                    }
                }
                if (Math.abs(this.coeffs[imax][e]) > EPSILON_PIVOT) {
                    return imax;
                } else {
                    return -1;
                }
            }
        } else {
            throw new Error("erreur input e");

        }

    }

    public ResGauss descenteGauss() {
        int r = 1;
        int rang = 0;
        
        for (int j =0 ;j<this.nbrLig-1;j++){
        //while (this.lignePlusGrandPivot(j)!=-1){
        
        
                r = r * this.permuteLigne(j, this.lignePlusGrandPivot(j));
                for (int i = j + 1; i < this.nbrLig; i++) {
                     
                    this.transvection(j, i);
                  
                }
            }
        for (int i =0;i<this.nbrLig ; i++){
            if (this.lignePlusGrandPivot(i)!=-1){
                rang++ ;
            }
        }

        ResGauss res = new ResGauss(rang, r);
        return res;
    }

    /*int r=1 ;
        
        for (int j = 0; j < this.nbrLig-1; j++) {
            r =r*this.permuteLigne(j,this.lignePlusGrandPivot(j));
            for(int i = j+1 ; i<this.nbrLig;i++){
            this.transvection(j,i);
            }
        
         
         
    }
           ResGauss res = new ResGauss(this.nbrLig-1 ,r); 
        return res ;
    }
     */
    public double determinant() {
        double det = 1;
        if (this.nbrCol == this.nbrLig) {
            this.descenteGauss();
            for (int i = 0; i < this.nbrLig; i++) {
                det = this.coeffs[i][i] * det;
            }
            return det * this.descenteGauss().sigPerm;
        } else {
            throw new Error("matrice non carree ");
        }
    }
    //probleme avec la remontee
    public void remonteeGauss(){
        
        
       
        for (int i=0 ; i<this.nbrLig ; i++){
            double  p = this.coeffs[i][i];
            for (int j =0;j<this.nbrCol ; j++ ){
                this.coeffs[i][j]=this.coeffs[i][j]/p;   
        }
        }
         for(int i = this.nbrLig-1 ; i>0;i--){
            for (int j =i-1 ; j>=0 ; j--){
                this.transvection(i,j);
                
            }
        }
    }
    public ResSys resolution (){
        this.descenteGauss();
        if (this.descenteGauss().rang==this.nbrCol-1){
            this.remonteeGauss();
            Matrice sol = new Matrice (this.nbrLig,1);
            for (int i = 0; i < sol.nbrLig; i++) {
                sol.coeffs[i][0]=this.coeffs[i][this.nbrCol-1];
                
            }
            
            ResSys res = new ResSys(sol , true);
            return res;
                }
        else {
           System.out.println(this.descenteGauss().rang);
           return null;
        }
       
    }
}

