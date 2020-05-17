# Music Visualiser Project

Name: Rachel Finucane

Student Number: C18735641

# Description of the assignment

# Instructions
Navigate to *C:\Users\rache\Documents\OOP_java\MusicVisuals\java* and run the compile.sh file on Windows or mcompile.sh on Mac. 
To run the project, click *run.sh* on Windows, or the *mrun.sh* file for Mac.
You should see the welcome screen. To run the music visuals, press the spacebar. The visuals automatically transition at appropriate times, so no need to press any 
buttons to see them. To go back to the beginning of the track (and visuals), press the spacebar again.

# How it works
MyVisual.java is a subclass of Visual, which extends PApplet. This is the java file that controls all other objects and sketches.
The instance of the MyVisual object is passed to each sketch, so that they can access the PApplet methods to draw to the screen.
MyVisual determines when these sketches run.
## MyVisual (The UI)

Each sketch is instantiated - for most we only need one object, but I decided to create three message objects to display a phrase of the song to the screen.

```Java
 loadAudio("Joywave - 01. Obsession.mp3");

        fl = new Flower(this);
        cv = new ClusterVisual(this);
        zv = new ZoomVisual(this);
        bz = new BoxZoom(this);
        tv = new TreeVisual(this);
        we = new Welcome(this);
        obsess = new Message(this, "OBSESSION", 100);
        hold = new Message(this, "hold in my sights", 50);
        get = new Message(this, "get me through the night", 50);
        no = new Noise(this);
```

Pressing the spacebar starts the audio playing, and sets a flag that the audio has begun. This flag is initially *false*, so that the welcome screen can display.

```Java
if (key == ' ') {
            started = true;
            getAudioPlayer().cue(0);
            getAudioPlayer().play();
        }
```

#### The draw() method

The current position of the audio is found. This is used to trigger different sketches rendering.

```Java
float position = getAudioPlayer().position();
```

Before playback begins, the welcome screen is displayed, with a background of particle effects.

```Java
if (started == false) {
            we.render();
            no.render();
        } 
				```
				
Once playback begins, MyVisual compares the current playback position to timestamps for various triggers. When it is between one trigger and the next, 
it renders the appropriate sketch. Below is an extract from this code.

				```Java
				
				else {

            if (position > 0 && position < t1) {
                fl.render();
                no.render();
            } else if (position > t1 && position < t2) {
                tv.render();
                no.render();
            }
```

Text is displayed alongside some images to coincide with lyrics in the chorus of the song. 

```Java            
            if (position > m1 && position < m1 + mLength) {
                obsess.render();
            } 
            else if (position > m2 && position < m2 + mLength) {
                get.render();
            } 

```

## The Sketches

### Box Zoom Visual

![Box](images/boxes.png)

#### BoxZoom.java

This class creates an arraylist of cube objects, each with starting co-ordinates of random x, y and z values. There are as many cubes as there are audio bands,
and the size of each cube corresponds to its audio band.

```Java
 boxes = new ArrayList<MyCube>();
        for (int i = 0; i < numBoxes; i++) {
            x = mv.random(-mv.width / 6, mv.width / 6);
            y = mv.random(-mv.height / 6, mv.height / 6);
            z = mv.random(-mv.height / 2, mv.height / 2);
            boxes.add(new MyCube(mv, boxSize, x, y, z, margin));
						
```

Every time the screen refreshes, each object in the arraylist is rendered on screen. The current frequency band is passed to the box's render method.

```Java
b.render(mv.getSmoothedBands()[i]);
```

#### MyCube.java

The size of the box to be drawn is calculated based on the frequency band, using the map() method. The MyCube.java class has x, y and z attributes that are not
reset every screen refresh. The render() method translates to the x, y and z co-ordinates and draws a box. Since the boxes are moving towards the screen, the z
value is increased - but if it reaches an upper limit, the z value is reset, and the x and y co-ordinates are set to random, making it appear at a random point
at the back of the screen.

```Java
				freqBandSize = MyVisual.map(freqBand, 0, 1000, size / 2, size * 2);
        speed = mv.getSmoothedAmplitude() * 10;
        mv.noFill();
        mv.stroke(255);
        mv.pushMatrix();
        mv.translate(mv.width / 2, mv.height / 2);
        mv.translate(x, y, z);
        mv.box(freqBandSize);
        mv.popMatrix();
        z += speed;

        if (z > mv.height / 2)
        {
            x = mv.random(-mv.width / 6, mv.width / 6);
            y = mv.random(-mv.height / 6, mv.height / 6);
            z = -mv.height;
        }
    }
```
	
### Cluster Visual

![Cluster](images/cluster.png)

```Java
 for (int i = 0; i < numSpheres; i++) {
            colour = MyVisual.map(i, 0, numSpheres, 0, 255);
            mv.noStroke();
            mv.fill(colour, 255, 255);
            offset = radius * i;
            mv.pushMatrix();
            for (int j = 0; j < numSpheres + 2 * i; j++) {

                freqBandRadius = MyVisual.map(mv.getSmoothedBands()[i], 0, 1000, 0.4f * radius, 1.6f * radius);
                angle = MyVisual.map(j, 0, numSpheres + 2 * i, 0, MyVisual.TWO_PI);

                mv.pushMatrix();
                X = MyVisual.cos(angle) * (dist + offset);
                Y = -MyVisual.sin(angle) * (dist + offset);
                mv.translate(X, Y, 0);

                mv.sphere(freqBandRadius);
                mv.popMatrix();

                mv.pushMatrix();
                mv.rotateX(MyVisual.PI);
                X = MyVisual.cos(angle) * (dist + offset);
                Y = -MyVisual.sin(angle) * (dist + offset);
                mv.translate(X, Y, 0);

                mv.sphere(freqBandRadius);
                mv.popMatrix();

                mv.rotateX(MyVisual.TWO_PI / (numSpheres + ( 2 * i)));
            }
            mv.popMatrix();
            mv.rotateX(MyVisual.TWO_PI / (numSpheres));
        }
``` 

### Flower/Lotus Visual

![Flower](images/lotus.png)

```Java
for (int i = 0; i < numRows; i++) {

            mv.fill(rColor, 255, 255);
            pY = MyVisual.map(mv.getSmoothedBands()[i], 0, 1000, mv.height / 12, mv.height / 2);

            for (int j = 0; j < numPetals; j++) {
                rowAngleOffset = MyVisual.map(i, 0, numPetals, MyVisual.HALF_PI, 0);
                mv.pushMatrix();
                mv.rotateX(rowAngleOffset);
                mv.ellipse(rX, rY + (pY / 2), pX, pY);
                
                mv.popMatrix();
                mv.rotate(MyVisual.TWO_PI / numPetals);
            }
            
            // offset petals for next row
            mv.rotate(pOffset);

            // reduce petal size
            pY = pY * 0.9f;
            rColor += (255 / numRows);
        }
```

### Message
![Message](images/boxes.png)
```Java
for (int i = 0; i < numWords; i++) {
            mv.textSize(size);
            mv.fill(colour, 255, fade);
            mv.text(message, 0, 0);
            colour = (colour + 1) % 255;
            mv.translate(0, yTransform, -yTransform);
            fade = fade / 3;
        }``` 
				

```Java
if (increasing == true) {
            angle += 0.001;

            if (angle > MyVisual.PI * 0.05) {
                increasing = false;
            }
        }

        else {
            angle -= 0.001;
            if (angle < -MyVisual.PI * 0.05) {
                increasing = true;
            }
        }
				
				```
				
### Noise (Background)

```Java
public void render()
    {
        int numPoints = 200;
        mv.stroke(255);
        for(int i = 0; i < numPoints; i++)
        {
            mv.point(mv.random(mv.width ), mv.random(mv.height), mv.random(mv.width / 2));
        }
    }
		
		```
### Welcome Screen

![Welcome](images/welcome.png)

```Java
    public void render() {
        String title = "Welcome";
        String subtitle = "Press space to start";
        float titleSize = mv.width / 10f;
        float subtitleSize = mv.width / 20f;

        int titleFill = 100;
        int subtitleFill = 200; 

        mv.textAlign(MyVisual.CENTER);
        mv.fill(titleFill, 255, 255);
        mv.textSize(titleSize);

        mv.text(title, mv.width / 2, mv.height / 2);
        mv.fill(subtitleFill, 255, 255);
        mv.textSize(subtitleSize);
        mv.text(subtitle, mv.width / 2, mv.height / 2 + 50);
        mv.rotateY(angle);

    }
		
```

### Tree Visual

![Tree](images/tree.png)

hyperlink that one website

```Java
public void render() {
        mv.pushMatrix();
        mv.stroke(255);
        mv.pushMatrix();
        mv.translate(mv.width / 2, mv.height - margin);
        drawBranch(branchHeight);
        mv.popMatrix();
        mv.translate(mv.width / 2, mv.height - margin - branchHeight);
        drawSelf(branchHeight);

        angle = MyVisual.map(mv.getSmoothedAmplitude(), 0, 1, 1f * staticAngle, 1.5f * staticAngle);
        mv.popMatrix();
    }

```

```Java
private void drawSelf(float bHeight) {
        bHeight = bHeight * branchReduction;
        if (bHeight > 30) {

            mv.pushMatrix();
            mv.rotate(angle);
            drawBranch(bHeight);
            mv.translate(0, -bHeight);
            drawSelf(bHeight);
            mv.popMatrix();

            mv.pushMatrix();
            mv.rotate(-angle);
            drawBranch(bHeight);
            mv.translate(0, -bHeight);
            drawSelf(bHeight);
            mv.popMatrix();

        }

    }
```

```Java
for (int i = 0; i < numLines; i++) {
            lnAngle = MyVisual.map(i, 0, numLines, 0, MyVisual.TWO_PI);

            x = MyVisual.cos(lnAngle) * distance;
            z = MyVisual.sin(lnAngle) * distance;

            mv.line(x, 0, z, x, -bHeight, z);
        }
        if (bHeight < branchHeight / 4) {
            drawLeaves(bHeight);
        }
```

```Java
for (int i = 0; i < numLines; i++) {
            colour = MyVisual.map(i, 0, numLines, 0, 255);
            leafHeight = MyVisual.map(mv.getSmoothedBands()[i], 0, 1000, leafMin, leafMax);
            mv.fill(colour, 255, 255);
            mv.noStroke();
            mv.pushMatrix();
            mv.popMatrix();
            mv.ellipse(leafHeight * 1.5f, 0, leafHeight, distance);
            mv.rotate(MyVisual.TWO_PI / numLines);

        }
```


### Zoom Visual
![Welcome](images/zoom1.png)

```public void render() {

        float colour = 0;
        float max = (float) Math.sqrt(mv.height * mv.height + mv.width * mv.width);
        float curr = max;
        int numCircs = 20;
        float colourInc = 255 / numCircs;
        float speed = max / numCircs;
        int maxSpeed = 100;

        mv.noStroke();
        mv.translate(mv.width / 2, mv.height / 2);
        while (curr > 0) {
            colour = (colour + colourInc) % 255;
            mv.fill(colour, 255, 255);
            mv.circle(0, 0, curr);

            if (mv.getAmplitude() > 0) {
                curr -= speed - MyVisual.map(mv.getSmoothedAmplitude(), 0, 1, 0, maxSpeed);
            } else {
                curr -= speed;
            }

        }

    }
```


# What I am most proud of in the assignment
- the entire lotus sketch
- figuring out the timing
- cluster
- getting the leaves around the tree
- working out how to make the zoom visual - how to get around the last drawn thing being on top

# Markdown Tutorial

This is *emphasis*

This is a bulleted list

- Item
- Item

This is a numbered list

1. Item
1. Item

This is a [hyperlink](http://bryanduggan.org)

# Headings
## Headings
#### Headings
##### Headings

This is code:

```Java
public void render()
{
	ui.noFill();
	ui.stroke(255);
	ui.rect(x, y, width, height);
	ui.textAlign(PApplet.CENTER, PApplet.CENTER);
	ui.text(text, x + width * 0.5f, y + height * 0.5f);
}
```

So is this without specifying the language:

```
public void render()
{
	ui.noFill();
	ui.stroke(255);
	ui.rect(x, y, width, height);
	ui.textAlign(PApplet.CENTER, PApplet.CENTER);
	ui.text(text, x + width * 0.5f, y + height * 0.5f);
}
```

This is an image using a relative URL:

![An image](images/p8.png)

This is an image using an absolute URL:

![A different image](https://bryanduggandotorg.files.wordpress.com/2019/02/infinite-forms-00045.png?w=595&h=&zoom=2)

This is a youtube video:


[![YouTube](http://img.youtube.com/vi/NGQbYEESZEg/0.jpg)](https://www.youtube.com/watch?v=NGQbYEESZEg)


This is a table:

| Heading 1 | Heading 2 |
|-----------|-----------|
|Some stuff | Some more stuff in this column |
|Some stuff | Some more stuff in this column |
|Some stuff | Some more stuff in this column |
|Some stuff | Some more stuff in this column |

