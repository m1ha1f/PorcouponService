package parsers;

import main.Offer;

public abstract class Parser 
{
 abstract Offer next();
 abstract boolean hasNext();
}