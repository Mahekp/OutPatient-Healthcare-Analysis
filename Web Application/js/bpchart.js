function loadBPChart() {
var marginTop = 40;
var marginBottom = 35;
var marginRight = 15;
var marginLeft = 50;
var height = 320 - marginTop - marginBottom;
var width = 480 - marginLeft - marginRight;

var svgSelection = d3.select('#chart1')
    .append("svg")
    .style("opacity", 0.6)
    .attr("width", width + marginLeft + marginRight)
    .attr("height", height + marginTop + marginBottom);

var baseGroup = svgSelection
    .append("g")
    .attr("transform", "translate("+marginLeft+","+marginTop+")");

var yScale = d3.scale.linear()
    .range([height,0])
    .domain([40,180])
    .clamp(true);   

var xScale = d3.scale.linear()
    .range([0, width]);

var colorScale = d3.scale.ordinal()
    .range(["black", "#008080", "#2E8B57", "#2E8B57", "#90EE90","2F4F4F"]);

var hoverLabel = d3.scale.ordinal()
    .range(["VERYLOW","LOW", "NORMAL", "PRE", "STAGE1", "STAGE2"]);

var yAxis = d3.svg.axis()
    .scale(yScale)
    .tickSize(-width, 0, 0)
    .orient("left");


var xBar = d3.svg.axis()
    .scale(xScale)
    .orient("bottom");
    
    var dataset = [
      { diastolic: 40, VERYLOW: 40, LOW: 50, NORMAL: 30, PREHYPERTENSION: 20, STAGE1: 20, STAGE2: 20 },
      { diastolic: 40, VERYLOW: 0, LOW: 90, NORMAL: 30, PREHYPERTENSION: 20, STAGE1: 20, STAGE2: 20 },
      { diastolic: 60, VERYLOW: 0, LOW: 90, NORMAL: 30, PREHYPERTENSION: 20, STAGE1: 20, STAGE2: 20 },
      { diastolic: 60, VERYLOW: 0, LOW: 0, NORMAL: 120, PREHYPERTENSION: 20, STAGE1: 20, STAGE2: 20},
      { diastolic: 80, VERYLOW: 0, LOW: 0, NORMAL: 120, PREHYPERTENSION: 20, STAGE1: 20, STAGE2: 20 },
      { diastolic: 80, VERYLOW: 0, LOW: 0, NORMAL: 0, PREHYPERTENSION: 140, STAGE1: 20, STAGE2: 20 },
      { diastolic: 90, VERYLOW: 0, LOW: 0, NORMAL: 0, PREHYPERTENSION: 140, STAGE1: 20, STAGE2: 20 },
      { diastolic: 90, VERYLOW: 0, LOW: 0, NORMAL: 0, PREHYPERTENSION: 0, STAGE1: 160, STAGE2: 20 },
      { diastolic: 100, VERYLOW: 0, LOW: 0, NORMAL: 0, PREHYPERTENSION: 0, STAGE1: 160, STAGE2: 20 },
      { diastolic: 100, VERYLOW: 0, LOW: 0, NORMAL: 0, PREHYPERTENSION: 0, STAGE1: 0, STAGE2: 180 },
      { diastolic: 120, VERYLOW: 0, LOW: 0, NORMAL: 0, PREHYPERTENSION: 0, STAGE1: 0, STAGE2: 180 }
];


// each key (age), uses a map to create all the objects for that age
// i in the anonymous function passed to map is the index of the dataset array, so can be used as the ID
var newDataset = ["VERYLOW", "LOW", "NORMAL", "PREHYPERTENSION", "STAGE1","STAGE2"].map(function(n){
    return dataset.map(function(d, i){
           return { x: d.diastolic, y: d[n], y0: 0 };
       });
});

d3.layout.stack()(newDataset);

xScale.domain(d3.extent(dataset, function(d) { return d.diastolic }))

baseGroup.append("g")
      .attr("class", "xaxis")
      .attr("transform", "translate(0," + height + ")")
      .call(xBar);   
      
baseGroup.append("text")
        .attr("transform", "translate(" + (width / 2) + " ," + (height + marginBottom) + ")")
        .style("text-anchor", "middle")
        .text("Diastolic BP");

baseGroup.append("g")
      .attr("class", "yaxis")
      .call(yAxis);

baseGroup.append("text")
        .attr("transform", "rotate(-90)")
        .attr("y", 0 - marginLeft)
        .attr("x",0 - (height / 2))
        .attr("dy", "1em")
        .style("text-anchor", "middle")
        .text("Systolic BP");
 /* .selectAll(".point")
      .data([{x:70, y:100}])
      .enter().append("path")
      .attr("class", "point")
      .attr("d", d3.svg.symbol().type("triangle-up"))
      .attr("transform", function(d) { return "translate(" + xBar(d.x) + "," + yAxis(d.y) + ")"; });*/
var area = d3.svg.area()
    .x(function(d) { return xScale(d.x); })
    .y0(function(d) { return yScale(d.y0); })
    .y1(function(d) { return yScale(d.y + d.y0); });

var bpGroup = baseGroup.selectAll(".valgroup")
    .data(newDataset)
    .enter()
    .append("g")
    .attr("class", "valgroup")
    .style("fill", function(d, i) { return colorScale(i); })
    .attr("class", function(d, i) { return hoverLabel(i); })

var xVar = [4, 55, 132, 185, 255];
var yVar = [-5, 45, 122, 175, 245];
bpGroup.append("rect")
    .attr("width", 10)
    .attr("height", 10)
    .style("fill", function(d, i) { if(i!= 0) return colorScale(i); })
    .attr("transform",function(d, i) {
      if(i==0) return "";
      var x = xVar[i-1];
      var translate = "translate("+ x +",-20)";
      return translate;
     })
bpGroup.append("text")
    .attr("x", 24)
    .attr("y", -9)
    .text( function(d, i) {if(i!= 0) return hoverLabel(i); })
    .attr("transform",function(d, i) {
      if(i==0) return "";
      var x = yVar[i-1];
      var translate = "translate("+ x +",-2)";
      return translate;
     });

bpGroup.append("path")
    .attr("d", function(d) { return area(d); });
   xScale.domain(d3.extent(dataset, function(d) { return d.diastolic }))
var xMap = function(d) { return xScale(d.x);}
var yMap = function(d) { return yScale(d.y);} 
 baseGroup.selectAll(".dot")
      .data([{x:60, y: 80}])
      .enter().append("circle")
      .attr("class", "dot")
      .attr("r", 5.5)
      .attr("cx", xMap)
      .attr("cy", yMap)
      .style("fill", function(d) { return "black";})
}
function loadStepsChart() {
}