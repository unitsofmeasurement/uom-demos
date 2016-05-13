/**
 *  Unit-API - Units of Measurement API for Java
 *  Copyright 2013-2014, Jean-Marie Dautelle, Werner Keil, V2COM and individual
 *  contributors by the @author tag.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *  http://www.apache.org/licenses/LICENSE-2.0
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
/**
 <h1>Fundamentals of heat transfer</h1>

<font size="1">&copy; Dagego</font>


<h2>Introduction</h2>



How do I calculate a heat exchanger, and what is the ideal size of a heat exchanger? These and similar questions arise in the planning, but no later than the construction of a cogeneration unit. 

A too large dimensioned exchanger unnecessarily costs a lot of money. An under-sized heat exchanger, the motor drives the sweat on the head gasket. In the worst case, so to speak, he can twist his head off. The properly sized heat exchanger not only increases the life of the engine. He saves his life. 

Since, however, are not going to get tons of oversized heat exchanger, we want to turn to the basics. In this excursion the physical quantities to be considered, the layman can handle the size indicated by the manufacturer. The physicist forgive the not always correct in detail dealing with the physical quantities. 


The physical quantities



To be able to do some calculations we will meet briefly four parameters. 

Thermal power P in [KW] 
The thermal power P is transferred to the heat exchanger is equal to the heat output generated in CHP motor. In practice, this is not entirely true, as the water cools down slightly on the way to the heat exchanger. We ignore this line losses since our system is well insulated. 

Temperature difference Delta T [C] 
That is the difference between flow and return. Thus, the temperature before the heat exchanger and behind the heat exchanger. Before the heat exchanger eg 65C is measured and after the heat exchanger 45C. The temperature difference is thus 20C. The term Delta T describes the temperature difference between input and output. The term Delta is a letter of the Greek alphabet. The letter looks like a small triangle. 

Flow rate Q in [L / h] 
It is also important how fast the fluid flows through the heat exchanger, because it "carries" yes heat. The more heat zoom is accomplished, the more can also be transmitted. 

Specific heat capacity c in [kJ / kg K] 
Do not worry. In order to make a statement about the heat storage capacity of a medium, there is the constant c. It tells us how much energy can be stored in a particular medium. Water has a storage capacity of 4200 J / kg K. 

3600 
Then there is a constant which is derived from the translation of the second to an hour. And although the number 3600. It results from 60 * 60th 


We can find this information in the following formula again. 

P = Q * Delta T * c / 3600 

The formula indicates how large the heat output P, ​​which is delivered to a heat exchanger, at a certain temperature difference and a given flow rate. 

However, it is a condition that the heat exchanger is capable of doing. More on that later. 

So, if the flow rate and the temperature before and after the heat exchanger as well known and the medium, then one can calculate how much energy is being implemented. 

In the following it is assumed that water as heat carrier medium. 


A small example



A boiler generates heat. Which is supplied by means of a pump to a heater. The system is water. It is heated in the boiler, transported with the pump to the heater and cooled back of the radiator. The radiator is a heat exchanger. He releases the heat of the medium water to the medium air. The water is therefore hotter than after the heat exchanger before the heat exchanger. The velocity of the water in the radiator is 1000 L / h. The temperature in front of the radiator is 65C. Behind the radiator, the water has only 50C. 

As we have mentioned previously, the unreacted heat output of a heat exchanger depends on the flow rate, the temperature difference before and after the heat exchanger. 

P = Q * Delta T * c / 3600 

used the results 

P = 1000 L / h * (65C - 50C) * 4200/3600 

P = 17500 W 

or P = 17,5KW 

As we have seen, we can now answer the following question: How much heat output is delivered to a radiator (heat exchanger), when water at a rate of 1000 L / h flow through the radiator and thereby cools from 65C to 50C? 


More results.



Let us imagine that the speed of the pump is increased. What actually means that more heat is managed zoom. Now, if the heat exchanger is capable emit warmth, and of course provides the heat source, then have the same temperature difference may be present. But .... 

P = Q * Delta T * c / 3600 

used the results 

P = 1500 L / h * (65C - 50C) * 4200/3600 

P = 26250 W 

or 

P = 26.25 KW 

... There's a lot more heat !! 

So what happened? If the flow rate is increased, so more heat will zoom managed to get out at the same temperature difference, the heat would have to rise to the heat exchanger. And that happened. 

Next: 

In calculating the temperature difference, the difference is crucial. And you might as well take minus 65C 50C 15C can enter the result. It follows that a temperature difference of 165C would have led to the same result minus 150C. 
We expect once with a temperature difference of 45C and 1000 L / h. 

P = Q * Delta T * c / 3600 

used the results 

P = 1000 L / h * 45C * 4200/3600 

P = 52500 W 

or 

P = 52.5 KW 

Thus, the greater the temperature difference, the greater the power to be transmitted. Is that good? 

Sure, I can size the heat exchanger smaller and increase the temperature difference. And now I have a small, cute, totally sufficient plus cheap heat exchanger. 

Quite so simple but it is not. 

Because if that really is so good, then why have not the radiator our homes a temperature difference of 60C? They would become smaller and cheaper. The answer is: Because the boiler does not like. It is thus drastically reduces the life! If permanent water must be brought to 70C with such low temperatures that are very fast, stress cracks in the material, condensation and thereby rust. Furthermore, everyone can imagine that each boiler is not in a position to apply such energies. 

An internal combustion engine is comparable. One should not bring about such a state. The smaller the temperature gradient, the smaller the problems which one gets it. 

The temperature difference should not be for reasons of cost under 5C. However, but it should not exceed 15C. When choosing a heat exchanger, a small temperature difference between the motor supply and return should always be selected. 

Thus, when the power to be transmitted is fixed, and also the temperature difference remains as a variable to be changed, only the flow rate desired. The above formula is thus changed according to the flow rate. 

From 

P = Q * Delta T * c / 3600 

shall 

Q = P / (Delta T x 4200/3600) 


Summary



The starting point is therefore the maximum heat production. The temperature difference should be about 5C be selected. Substituted into the above formula yields the flow rate required. Must be chosen in order to obtain the flow rate and the right pump, and associated pipe cross sections. 

As an example for us, an engine which has a 11 KW generator drives great. It will produce about 10 kW thermal power (without exhaust heat). The numbers are used to calculate the flow rate of the medium. 

From 

P = Q * Delta T * c / 3600 

shall 

Q = P / (Delta T x 4200/3600) 

used the results 

Q = 10 kW / (5C x 4200/3600) 

Q = 1710 L / h 

That's not enough! We try out a temperature difference of 10C. 

Q = P / (Delta T x 4200/3600) 

used the results 

Q = 10 kW / (10C x 4200/3600) 

Q = 860 L / h 

The one creates a standard heating pump if you have complied with reasonable cross sections for the tubes. If the pump more, then sets a temperature difference of something between 5C and 10C. That's good. Condition is that the heat exchanger is capable of doing. For higher ratings will either rise or the temperature difference, the pump performance. In the following example, we assume 30KW from: 

Q = P / (Delta T x 4200/3600) 

used the results 

Q = 30 kW / (10C x 4200/3600) 

Q = 2570 L / h 

So that to make that, not only the pump must pay more. The cross-sections of pipes and connections must be large enough. Each taper to the brake and worsens the outcome. 
 * 
 * @see <a href="http://www.dagego.de/info_grundlagen_waermeuebertragung.html">Dageto: Grundlagen der Wärmeübertragung (DE)</a>
 * 
 * @author Werner Keil
 *
 */
package tec.uom.demo.energy;