# Formulas
Here you'll find all the formulas in a somewhat understandable way.

### Definition of certain terms
| Term | Definition | Calculation |
|:----------------:|:--------------|:-------------:|
| throatArea | The throat area is the tightest area in a rocket engine. <br/> It is used to concentrate the flow of matter to an optimal speed of Mach 1 | (D/2)^2 * PI |
| totalPressure | The total pressure is the entire pressure of the gases <br/> inside of the combustion chamber |  |
| totalTemperature |  |  |
| heatRatio |  |  |
| gasConstant |  |  |
| ***standardPow*** |  |  |
||||
| mDot |  |  |
| A | A is used to describe a certain area of something. <br/> Ae is the area at any point in the exhaust system |  |

## "Translated" Calculations
<br /> Used three times | (constant)	=		(heatRatio + 1) / 2 (heatRatio - 1)
<br /> Mass Flow Rate 	| (mdot)		= 		throatArea * (total pressure / sqrt(total temperature)) * sqrt(heatRatio / gas constant) * pow((heatRatio + 1) / 2, - constant)
<br /> Exit mach 		| (Ae / A*)	    =		pow((heatratio + 1) / 2, -constant) * pow(((1 + (heatRatio - 1) / 2 * pow(Me, 2)) / Me), +constant)
<br /> Exit temperature | (Te / Tt)	    =		pow((1 + (heatRatio - 1) / 2 * pow(Me, 2), -1)
<br /> Exit pressure 	| (pe / pt)	    =		pow(1  + (heatRatio - 1) / 2 * pow(Me, 2), -heatRatio / (heatRatio - 1))
<br /> Exit velocity 	| (Ve)		    =		pow(Me, 2) * sqrt(heatRatio * gasConstant * totalTemperature)
<br /> Thrust 			| (F) 		    = 		mdot * Ve + (pe - freeStreamPressure) * Ae