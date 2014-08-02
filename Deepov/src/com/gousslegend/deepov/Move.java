package com.gousslegend.deepov;

import com.gousslegend.deepov.pieces.Piece;

public class Move
{
	private Position myOrigin;
	private Position myDestination;
	private Piece myCapturedPiece;
	private int myScore;
	private boolean myIsPromotion;

	public Move(Position origin, Position destination)
	{
		setOrigin(origin);
		setDestination(destination);
	}

	public Position getOrigin()
	{
		return myOrigin;
	}

	public void setOrigin(Position myOrigin)
	{
		this.myOrigin = myOrigin;
	}

	public Position getDestination()
	{
		return myDestination;
	}

	public void setDestination(Position myDestination)
	{
		this.myDestination = myDestination;
	}

	public int getScore()
	{
		return myScore;
	}

	public void setScore(int myScore)
	{
		this.myScore = myScore;
	}

	public Piece getCapturedPiece()
	{
		return myCapturedPiece;
	}

	public void setCapturedPiece(Piece myCapturedPiece)
	{
		this.myCapturedPiece = myCapturedPiece;
	}

	@Override
	public String toString()
	{
		return "Move [org=" + myOrigin + ", dest="
				+ myDestination + ", Captured=" + myCapturedPiece + "]" + "\n";
	}

	public boolean isPromotion()
	{
		return myIsPromotion;
	}

	public void setIsPromotion(boolean myIsPromotion)
	{
		this.myIsPromotion = myIsPromotion;
	}

}
