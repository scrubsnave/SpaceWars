package com.mycompany.a4;

import com.codename1.charts.models.Point; //could be another Point
import com.codename1.ui.Graphics;

public interface IDrawable {
	void draw(Graphics g, Point pCmpRelPrnt);
}
