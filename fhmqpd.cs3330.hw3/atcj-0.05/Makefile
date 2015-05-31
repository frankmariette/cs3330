ifeq ($(OS),Windows_NT)
 ifeq ("$(JAVA_HOME)","")
  JAVA=java.exe
  JAVAC=javac.exe -target 1.1
  JAR=jar.exe
  JAVADOC=javadoc.exe
  APPLETVIEWER=appletviewer.exe
 else
  JAVA=$(JAVA_HOME)/bin/java.exe
  JAVAC=$(JAVA_HOME)/bin/javac.exe -target 1.1
  JAR=$(JAVA_HOME)/bin/jar.exe
  JAVADOC=$(JAVA_HOME)/bin/javadoc.exe
  APPLETVIEWER=$(JAVA_HOME)/bin/appletviewer.exe
 endif
else
  JAVA=$(JAVA_HOME)/bin/java
  JAVAC=$(JAVA_HOME)/bin/javac -target 1.1
  JAR=$(JAVA_HOME)/bin/jar
  JAVADOC=$(JAVA_HOME)/bin/javadoc
  APPLETVIEWER=$(JAVA_HOME)/bin/appletviewer
endif

CLASSES_EXTRA= main.class\
	 WindowUtilities.class

CLASSES= eyu/atc/Position.class \
	 eyu/atc/Direction.class \
	 eyu/atc/Turn.class \
	 eyu/atc/Command.class \
	 eyu/atc/ALTCommand.class \
	 eyu/atc/DIRCommand.class \
	 eyu/atc/TurnCommand.class \
	 eyu/atc/CircleCommand.class \
	 eyu/atc/ATCObj.class \
	 eyu/atc/StaticObj.class \
	 eyu/atc/Beacon.class \
	 eyu/atc/Exit.class \
	 eyu/atc/Airfield.class \
	 eyu/atc/Line.class \
	 eyu/atc/MovingObj.class \
	 eyu/atc/Plane.class \
	 eyu/atc/ATC.class \
	 eyu/atc/ATCUI.class \
	 eyu/atc/ATCData.class \
	 eyu/atc/ATCInputhandler.class \
	 eyu/atc/ATCConfig.class \
	 eyu/atc/ATCConfig_from_stream.class \
	 eyu/atc/ATCRecord.class \
	 eyu/atc/ATCRecord_impl.class \
	 eyu/atc/ATCUI_dummy_impl.class \
	 eyu/atc/ATCUI_impl.class \
	 eyu/atc/ATCUI_impl_awt.class \
	 eyu/atc/ATCInputhandler_impl.class \
	 eyu/atc/ATCGameOverException.class

.SUFFIXES: .class .java

.java.class:
	$(JAVAC) $<

all: $(CLASSES) atc.jar $(CLASSES_EXTRA)

atc.jar: $(CLASSES)
	"$(JAR)" cf atc.jar eyu/atc/*.class

run: all
	$(JAVA) main

runapplet: all
	$(APPLETVIEWER) run.html

javadoc:
	cd doc && "$(JAVADOC)" ../eyu/atc/*.java

