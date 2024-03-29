//Copyright (C) 2003 Zheli Erwin Yu
//
//This file is part of ATCJ.
//
//ATCJ is free software; you can redistribute it and/or modify
//it under the terms of the GNU General Public License as published by
//the Free Software Foundation; either version 2 of the License, or
//(at your option) any later version.
//
//ATCJ is distributed in the hope that it will be useful,
//but WITHOUT ANY WARRANTY; without even the implied warranty of
//MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
//GNU General Public License for more details.
//
//You should have received a copy of the GNU General Public License
//along with ATCJ; if not, write to the Free Software
//Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA

package eyu.atc;

import java.lang.Object;
import java.lang.String;

public interface ATCUI
{
  public void initUI( int dx, int dy );

  public void StaticObjNew( StaticObj so );
  public void CommandUpdate( String cmd_str );
  public void PlaneNew( Plane p );
  public void PlaneUpdate( Plane p );
  public void PlaneRemove( Plane p );
  public void InfoUpdate( int tick_count, int safe_count );

  public void ready();

  public void start();

  public void gameOver( String s );

  public void refresh();

  public void close();
};

