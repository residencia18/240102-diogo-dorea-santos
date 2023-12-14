package Poligono2;

public class Ponto {
	float x, y;
	Ponto(float _x, float _y) {
		x = _x;
		y = _y;
	}
	
	float getX()...
	float getY()...
	
	float distancia(Ponto p) {
		return sqrt( pow(this.x-p.getX(),2) + pow(this.y-p.getY(),2) );
	}
	
	static Ponto solicitaPonto() {
		syso("Digite as coordenadas");
		float x <- teclado
		float y <- teclado
		return new Ponto(x,y)
	}
}
