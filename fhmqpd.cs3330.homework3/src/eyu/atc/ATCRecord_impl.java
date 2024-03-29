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

public class ATCRecord_impl implements ATCRecord
{
	/**
	 * Saves user
	 * @param String user
	 * @param String config_name
	 * @param int time
	 * @param long real_time
	 * @param int safe_count
	 * 
	 * 
	 */
  public void save( String user, String config_name, 
                    int time, long real_time, int safe_count )
  {
    System.out.println(
        "User: " + user +
        ", Game: " + config_name +
        ", Time: " + time +
        ", Real time: " + (double)real_time/1000 + "s" +
        ", Safe: " + safe_count );
  }
};
