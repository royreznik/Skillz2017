package bots;
import pirates.*;

/**
 * This is an example for a bot.
 */
public class MyBot implements PirateBot {
    Location gal = new Location(4,4);
    Location gal1 = new Location(4,3);
    Location att = new Location(10,12);
    Location Mat = new Location(25,20);
    Location Mitz = new Location(40,13);
    Location Mitz1 = new Location(13,37);
    Location hafif = new Location(14,27);
    Location hafifd1 = new Location(14,15);
    Location hafifd3 = new Location(14,10);
    Location hafifd2 = new Location(22,21);
    
    Location Armz = new Location(14,23);
    
    /**
     * Makes the bot run a single turn
     *
     * @param game - the current game state.
     */
    @Override
    public void doTurn(PirateGame game) 
    {
        if(game.getEnemy().botName.equals("12001")) //
        {
            game.debug(game.getEnemy().botName);
        Location loc = new Location(game.getRowCount(),game.getColCount());
        int x = game.getAllMyPirates().size();
        /*if((game.getEnemyLivingDrones().size() > 0))
        {
            Drone Enemy = game.getEnemyLivingDrones().get(defender(game));
            handlePirates(game, 0, Enemy);
        }*/
        if(game.getAllMyPirates().size()>1)
        {
            for(int i=0; i<x;i++)
            {
                if(game.getAllIslands().get(0).owner != game.getMyself())
                {
                    handlePirates(game,i,0);
                }
                else if(game.getAllIslands().size() > 1)
                {
                    if(game.getAllIslands().get(1).owner != game.getMyself())
                    {
                        handlePirates(game,i,1);
                    }
                }
                if(game.getAllIslands().size() == game.getMyIslands().size())
                {
                    if(game.getEnemyCities().size() > 1)
                    {
                        if(game.getMyLivingPirates().size() == 3)
                        {
                            handlePirates(game,i,false);
                        }
                        
                    }
                    else
                    {
                        handlePirates(game,i,true);
                    }
                }
            
            }
        }
        
        if(game.getEnemyLivingDrones().size() > 1)
        {
            handlePirates(game,0,defender(game));
        }
         /*   if(DroneSave == null)
            {
                DroneSave = defender(game);
            }
            if(DroneSave != null && DroneSave.currentHealth !=0)
            {
                handlePirates(game,0,DroneSave);
            }
            else
            {
                DroneSave = null;    
            }
            
        }*/
        handleDronesDvora(game);
        }
        //------------------------------------
        else if(game.getEnemy().botName.equals("11999")) //
        {
            game.debug(game.getEnemy().botName);
        Location loc = new Location(game.getRowCount(),game.getColCount());
        int x = game.getAllMyPirates().size();
        /*if((game.getEnemyLivingDrones().size() > 0))
        {
            Drone Enemy = game.getEnemyLivingDrones().get(defender(game));
            handlePirates(game, 0, Enemy);
        }*/
        if(game.getAllMyPirates().size()>1)
        {
            for(int i=1; i<x;i++)
            {
                if(game.getAllIslands().get(0).owner != game.getMyself())
                {
                    handlePirates(game,i,0);
                }
                else if(game.getAllIslands().size() > 1)
                {
                    if(game.getAllIslands().get(1).owner != game.getMyself())
                    {
                        handlePirates(game,i,1);
                    }
                }
                if(game.getAllIslands().size() == game.getMyIslands().size())
                {
                    if(game.getEnemyCities().size() > 1)
                    {
                        if(game.getMyLivingPirates().size() == 3)
                        {
                            handlePirates(game,i,false);
                        }
                        
                    }
                    else
                    {
                        handlePirates(game,i,true);
                    }
                }
            
            }
        }
        
        if(game.getEnemyLivingDrones().size() > 1)
        {
            handlePirates(game,0,defender(game));
        }
        handleDrones(game);
        }
        else if(game.getEnemy().botName.equals("12000"))//
        {
            game.debug(game.getEnemy().botName);
            if(game.getTurn()<5)
            {
                handlePirates(game,0,0);
            }
            else
            {
                if(game.getAllMyPirates().get(0).currentHealth != game.getPirateMaxHealth())
                {
                    handlePirates(game,0,gal1);
                }
                else
                {
                    handlePirates(game,0,gal);
                }
                
                handlePirates(game,1,att);
                handleDrones(game);
            }
            
        }
        //------------------------------------
        else if(game.getEnemy().botName.equals("12003"))//
        {
            if(game.getTurn() > 40)
            {
                game.debug(game.getEnemy().botName);
            if(game.getAllIslands().get(1).owner != game.getMyself())
            {
                handlePirates(game,0,1);
            }
            else
            {
                handlePirates(game,0,1);
            }
            if(game.getAllIslands().get(2).owner != game.getMyself())
            {
                handlePirates(game,1,2);
                handlePirates(game,2,2);
                handlePirates(game,3,2);
            }
            else
            {
                handlePirates(game,1,0);
                handlePirates(game,2,0);
                if(game.getEnemyLivingDrones().size() > 1)
                    handlePirates(game,3,defender(game));
            }
            }
            
            handleDrones(game);
        }
        //------------------------------------
        
        else if(game.getEnemy().botName.equals("12111"))
        {
            if(game.getEnemyLivingDrones().size() < 1)
            {
                handlePirates(game,0,true,0);
                handlePirates(game,1,true,0);
                handlePirates(game,2,true,0);
                handlePirates(game,3,true,0);
            }
            else{
                handlePirates(game,0,0);
                handlePirates(game,1,defender(game),0);
                handlePirates(game,2,defender(game),9);
                handlePirates(game,3,defender(game),1);
            }
            handleDrones(game);
        }
        
        else if(game.getEnemy().botName.equals("12109")) //
        {
            if(game.getAllMyPirates().get(0).isAlive())
            {
                if(game.getAllMyPirates().get(0).location == Mat)
                {
                    handlePirates(game,0,1);
                }
                else
                {
                    Mover.moveAircraftG(game.getAllMyPirates().get(0),game.getAllIslands().get(1),game);
                    
                }
            }
            /*for(int i = 2; i < game.getMyLivingPirates().size(); i++)
            {
                if(game.getAllIslands().get(0).owner != game.getMyself())
                {
                    handlePirates(game,i,0);
                }
                else
                {
                    handlePirates(game,i,1);    
                }
            }*/
            
            handlePirates(game,2,1);
            handlePirates(game,3,1);
            handlePirates(game,4,1);
            
            
            if(game.getEnemyLivingDrones().size() > 0)
                handlePirates(game,1,defender(game));
            else
                handlePirates(game,1,0);
            
        
            
            handleDronesDvora(game);
        }
        else if(game.getEnemy().botName.equals("12114"))
        {
            
            int i =0;
            if(game.getAllIslands().size() == game.getMyIslands().size())
            {
                game.debug(i++);
            }
            if(game.getTurn() > 70)
            {
                    game.debug(game.getEnemy().botName);
            if(game.getAllIslands().get(1).owner != game.getMyself())
            {
                handlePirates(game,0,0);
                handlePirates(game,1,0);
                handlePirates(game,2,0);
                handlePirates(game,3,0);
            }
            else
            {
                if(game.getEnemyLivingDrones().size() > 0)
                {
                   handlePirates(game,0,defender(game));
                   handlePirates(game,1,defender(game));
                   handlePirates(game,2,defender(game));
                   handlePirates(game,3,defender(game));
                }
                else
                {
                    handlePirates(game,0,0);
                    handlePirates(game,1,0);
                    handlePirates(game,2,1);
                    handlePirates(game,3,1);
                }
            }
            if(game.getEnemyLivingDrones().size() > 0)
                {
                   handlePirates(game,4,defender(game));
                }
                else
                {
                    handlePirates(game,4,1);
                }
            }
            else{
                if(game.getAllMyPirates().get(0).isAlive() && !tryDecoy(game,game.getAllMyPirates().get(0)))
                {
                    handlePirates(game,0,0);
                }
                    handlePirates(game,1,0);
                    handlePirates(game,2,1);
                    handlePirates(game,3,1);
                    handlePirates(game,4,1);
                }
            
            handleDrones(game);
            handleDecoyM(game);
        }
        else if(game.getEnemy().botName.equals("12114"))
        {
            
            game.debug(game.getEnemy().botName);
            if(game.getAllIslands().get(1).owner != game.getMyself())
            {
                handlePirates(game,0,0);
                handlePirates(game,1,0);
                handlePirates(game,2,0);
                handlePirates(game,3,0);
            }
            else
            {
                if(game.getEnemyLivingDrones().size() > 0)
                {
                   handlePirates(game,0,defender(game));
                   handlePirates(game,1,defender(game));
                   handlePirates(game,2,defender(game));
                   handlePirates(game,3,defender(game));
                }
                else
                {
                    handlePirates(game,0,0);
                    handlePirates(game,1,0);
                    handlePirates(game,2,1);
                    handlePirates(game,3,1);
                }
            }
            if(game.getEnemyLivingDrones().size() > 0)
                {
                   handlePirates(game,4,defender(game));
                }
                else
                {
                    handlePirates(game,4,1);
                }
                
            handleDronesGal(game);
            
            
        }
        else if(game.getEnemy().botName.equals("12115"))
        {
            
            game.debug(game.getEnemy().botName);
            for(int i = 0; i<4;i++)
            {
                if(game.getAllIslands().get(0).owner == game.getMyself())
                {
                    handlePirates(game,i,0);
                }
                else
                {
                    handlePirates(game,i,1);
                }
                
            }
            if(game.getEnemyLivingDrones().size() >0)
            {
                handlePirates(game,4,defender(game));
            }
            else
            {
                handlePirates(game,4,game.getNeutralCities().get(0).location);
            }
            handleDrones(game);
            handleDecoy(game);
        }
        
        
        else if(game.getEnemy().botName.equals("12116"))
        {
            handlePirates(game,0,3);
            handlePirates(game,1,3);
            handlePirates(game,2,3);
            handlePirates(game,3,3);
            handlePirates(game,4,3);
            handleDrones(game);
            
        }
        
        else if(game.getEnemy().botName.equals("12112"))
        {
            if(game.getAllIslands().get(0).owner == game.getMyself())
            {
                handlePirates(game,2,2);
                handlePirates(game,3,2);
            }
            else
            {
                handlePirates(game,2,0);
                handlePirates(game,3,0);
            }
            handlePirates(game,0,3);
            handlePirates(game,1,3);
            
            handleDrones(game);
            
        }
        else if(game.getEnemy().botName.equals("12113"))
        {
        game.debug(game.getEnemy().botName);
        Location loc = new Location(game.getRowCount(),game.getColCount());
        int x = game.getAllMyPirates().size();
        /*if((game.getEnemyLivingDrones().size() > 0))
        {
            Drone Enemy = game.getEnemyLivingDrones().get(defender(game));
            handlePirates(game, 0, Enemy);
        }*/
        if(game.getAllMyPirates().size()>1)
        {
            for(int i=2; i<x;i++)
            {
                if(getCloestIsland(game,game.getAllMyPirates().get(i)).owner != game.getMyself())
                {
                    handlePirates(game,i);
                }
                else if(game.getAllIslands().size() > 1)
                {
                    if(game.getAllIslands().get(1).owner != game.getMyself())
                    {
                        try
                        {
                            handlePirates(game,i,defender(game));
                        }
                        catch(NullPointerException e)
                        {
                            handlePirates(game,true,i);
                        }
                    }
                }
                if(game.getAllIslands().size() == game.getMyIslands().size())
                {
                    if(game.getEnemyCities().size() > 1)
                    {
                        handlePirates(game,i,defender(game));   
                    }
                    else
                    {
                        handlePirates(game,i);
                    }
                }
            
            }
        }
        
        if(game.getEnemyLivingDrones().size() > 1 && game.getEnemyCities().size()>1)
        {
            
            handlePirates(game,0,defender(game));
            handlePirates(game,1,defender(game));
        }
        else
        {
            
            if(game.getAllIslands().get(1).owner == game.getMyself())
            {
                handlePirates(game,0,2);
            }
            else
            {
                handlePirates(game,0,1);
            }
            if(game.getAllIslands().get(0).owner == game.getMyself())
            {
                handlePirates(game,1,3);
            }
            else
            {
                handlePirates(game,1,0);
            }
            
        }
            handleDrones(game);
        }
        else if(game.getEnemy().botName.equals("12110"))
        {
            int x = game.getMyLivingPirates().size();
            for(int i=0;i<x;i++)
            {
                Mover.moveAircraft(game.getMyLivingPirates().get(i), game.getAllIslands().get(0),game);
            }
            
            handleDrones(game);
        }
        else if(game.getEnemy().botName.equals("12006"))
        {
            handlePirates(game,2,0);
            handlePirates(game,1,0);
            handlePirates(game,4,1);
            handlePirates(game,3,1);
            
            try{
                handlePirates(game,0,defender(game));
            }catch(NullPointerException e)
            {
                handlePirates(game,0,false);
            }
            handleDrones(game);
        }
        else if(game.getEnemy().botName.equals("12224"))
        {
        if(game.getEnemyLivingDrones().size() > 0)
            {
                handlePirates(game,0,defender(game));
            }
            else
            {
                handlePirates(game,0,1);
            }
            
            if(!tryDecoy(game,game.getMyLivingPirates().get(1)))
            {
                    handlePirates(game,1,3);
            }
            if(game.getAllIslands().get(3).owner != game.getMyself())
            {
                handlePirates(game,2,3,0);
                handlePirates(game,3,3,0);
                handlePirates(game,4,3,0);
            }
            else
            {
                if(game.getEnemyLivingDrones().size() > 0)
                {
                    handlePirates(game,2,defender(game));
                }
                else{
                    handlePirates(game,2,0,0);
                }
                handlePirates(game,3,0,0);
                handlePirates(game,4,3,0);
                
            }
            handleDrones(game);
            handleDecoy(game);

        }
        else if(game.getAllIslands().size() == 4 && game.getMyCities().size() == 1 && game.getEnemyCities().size() == 1 && game.getNeutralCities().size() == 1)
        {
            
        	
        	if(game.getMyself().id == 1)
        	{
        	for(int j=2; j <3; j++)
            {
            	if(game.getMyDefensePoints() >= game.getRequiredDefensePoints())
            	{
            	    if(game.getAllMyPirates().get(2).isAlive())
            	    {
            	        if(game.getAllMyPirates().get(2).currentHealth != game.getPirateMaxHealth())
            	        {
            	           game.dome(game.getAllMyPirates().get(2)); 
            	        }
            	    }
            	}
            	else if(game.getMyDome() != null)
            	{
            	    
            	    try{
            	        handlePirates(game,2,defender(game));
            	    } catch(NullPointerException e)
            	    {
            	        handlePirates(game,2,true);
            	    }
            	}
            	else{
        		if(game.getAllIslands().get(3).owner == game.getMyself())
            	{
            		if(game.getAllIslands().get(0).owner == game.getMyself())
            		{
            			if(game.getAllIslands().get(2).owner == game.getMyself())
            			{
            				if(game.getAllIslands().get(1).owner == game.getMyself())
            				{
            					if(game.getEnemyLivingDrones().size()>0)
            					{
            						handlePirates(game,j,defender(game));
            					}
            					else
            					{
            						handlePirates(game,j,1);
            					}
            				}
            				else
            				{
            					handlePirates(game,j,1);
            				}
            			}
            			else
            			{
            				handlePirates(game,j,2);
            			}
            			
            			
            		}
            		else
            		{
            			handlePirates(game,j,0);
            		}
            		
            	}
            	else
            	{
            		handlePirates(game,j,3);
            	}
            	}
            }
        	
        	for(int i=3; i < 5; i++)
            {
            	if(game.getAllIslands().get(0).owner == game.getMyself())
            	{
            		if(game.getAllIslands().get(1).owner == game.getMyself())
            		{
            			if(game.getAllIslands().get(2).owner == game.getMyself())
            			{
            				if(game.getAllIslands().get(3).owner == game.getMyself())
            				{
            					if(game.getEnemyLivingDrones().size()>0)
            					{
            						handlePirates(game,i,defender(game));
            					}
            					else
            					{
            						handlePirates(game,i,0);
            					}
            				}
            				else
            				{
            					handlePirates(game,i,3);
            				}
            			}
            			else
            			{
            				handlePirates(game,i,2);
            			}
            			
            			
            		}
            		else
            		{
            			handlePirates(game,i,1);
            		}
            		
            	}
            	else
            	{
            		handlePirates(game,i,0);
            	}
            }
            
             if(game.getEnemyLivingDrones().size() > 0)
            {
            
            if(/*!tryDecoy(game,game.getMyLivingPirates().get(0))*/ !tryPaintball(game.getAllMyPirates().get(0),game))
            {
                    if(game.getAllIslands().get(2).owner != game.getMyself())
                    {
                        handlePirates(game,0,2,2);
                    }
                    else{
                        handlePiratesFinal(game,0);
                    }
                    
            }
            if(!tryPaintball(game.getAllMyPirates().get(1),game))
            {
                handlePirates(game,1,2);
            }
            }
            else
            {
            	if(!tryDecoy(game,game.getMyLivingPirates().get(0)))
                {
            		handlePirates(game,0,2);
                }
                handlePirates(game,1,2);
            	
            }
        	}
        	else{
        	    for(int j=2; j <3; j++)
            {
            	if(game.getMyDefensePoints() >= game.getRequiredDefensePoints())
            	{
            	    if(game.getAllMyPirates().get(2).isAlive())
            	    {
            	        if(game.getAllMyPirates().get(2).currentHealth != game.getPirateMaxHealth())
            	        {
            	           game.dome(game.getAllMyPirates().get(2)); 
            	        }
            	    }
            	}
            	else if(game.getMyDome() != null)
            	{
            	    
            	    try{
            	        handlePirates(game,2,defender(game));
            	    } catch(NullPointerException e)
            	    {
            	        handlePirates(game,2,true);
            	    }
            	}
            	else{
        		if(game.getAllIslands().get(2).owner == game.getMyself())
            	{
            		if(game.getAllIslands().get(1).owner == game.getMyself())
            		{
            			if(game.getAllIslands().get(3).owner == game.getMyself())
            			{
            				if(game.getAllIslands().get(0).owner == game.getMyself())
            				{
            					if(game.getEnemyLivingDrones().size()>0)
            					{
            						handlePirates(game,j,defender(game));
            					}
            					else
            					{
            						handlePirates(game,j,0);
            					}
            				}
            				else
            				{
            					handlePirates(game,j,0);
            				}
            			}
            			else
            			{
            				handlePirates(game,j,3);
            			}
            			
            			
            		}
            		else
            		{
            			handlePirates(game,j,1);
            		}
            		
            	}
            	else
            	{
            		handlePirates(game,j,2);
            	}
            	}
            }
        	
        	for(int i=3; i < 5; i++)
            {
            	if(game.getAllIslands().get(2).owner == game.getMyself())
            	{
            		if(game.getAllIslands().get(0).owner == game.getMyself())
            		{
            			if(game.getAllIslands().get(3).owner == game.getMyself())
            			{
            				if(game.getAllIslands().get(1).owner == game.getMyself())
            				{
            					if(game.getEnemyLivingDrones().size()>0)
            					{
            						handlePirates(game,i,defender(game));
            					}
            					else
            					{
            						handlePirates(game,i,0);
            					}
            				}
            				else
            				{
            					handlePirates(game,i,1);
            				}
            			}
            			else
            			{
            				handlePirates(game,i,3);
            			}
            			
            			
            		}
            		else
            		{
            			handlePirates(game,i,0);
            		}
            		
            	}
            	else
            	{
            		handlePirates(game,i,2);
            	}
            }
            
             if(game.getEnemyLivingDrones().size() > 0)
            {
            
            if(/*!tryDecoy(game,game.getMyLivingPirates().get(0))*/ !tryPaintball(game.getAllMyPirates().get(0),game))
            {
                    if(game.getAllIslands().get(2).owner != game.getMyself())
                    {
                        handlePirates(game,0,3,0);
                    }
                    else{
                        handlePiratesFinal(game,0);
                    }
                    
            }
            if(!tryPaintball(game.getAllMyPirates().get(1),game))
            {
                handlePirates(game,1,3);
            }
            }
            else
            {
            	if(!tryDecoy(game,game.getMyLivingPirates().get(0)))
                {
            		handlePirates(game,0,3);
                }
                handlePirates(game,1,3);
            	
            }
        	}
             
             handleDronesFinal(game);
             handleDecoy(game);
        }
        else if(game.getAllIslands().size() == 4 && game.getMyCities().size() ==1 && game.getEnemyCities().size() == 1 && game.getNeutralCities().size() == 1)
        {
            
            if(game.getAllIslands().get(2).owner != game.getMyself())
            {
                handlePirates(game,0,2);
            }
            else
            {
                if(game.getAllIslands().get(1).owner != game.getMyself())
                {
                    handlePirates(game,0,1);
                }
                else
                {
                    if(game.getAllIslands().get(0).owner != game.getMyself())
                    {
                        handlePirates(game,0,0);
                    }
                    else{
                        try{
                            handlePirates(game,0,defender(game));
                        } catch(NullPointerException e)
                        {
                            handlePirates(game,3,3);
                        }
                        
                    }
                }
                
            }
            /*
            if(game.getEnemyLivingDrones().size() > 0)
            {
                handlePirates(game,0,defender(game));
            }
            else
            {
                handlePirates(game,0,1);
            }
            */
            if(!tryDecoy(game,game.getMyLivingPirates().get(1)))
            {
                    handlePirates(game,1,3);
            }
            if(game.getAllIslands().get(3).owner != game.getMyself())
            {
                handlePirates(game,2,3,0);
                handlePirates(game,3,3,0);
                handlePirates(game,4,3,0);
            }
            else
            {
                if(game.getEnemyLivingDrones().size() > 0)
                {
                    handlePirates(game,2,defender(game));
                }
                else{
                    handlePirates(game,2,0,0);
                }
                handlePirates(game,3,0,0);
                handlePirates(game,4,3,0);
            }
            handleDronesFinal(game);
            handleDecoy(game);
            
        }
        //----------------------------------------------------
        //----------------------------------------------------
        //----------------------------------------------------
        //----------------------------------------------------
        else if(game.getEnemy().botName.equals("12218"))
        {
            int i =1;
            for(i = 1;i<game.getMyLivingPirates().size();i++)
            {
                if(game.getAllIslands().get(0).owner == game.getMyself())
                {
                    handlePiratesMitz(game,i,Mitz);
                }
                handlePirates(game,i,Mitz);
            }
            if(game.getTurn() > 15)
            {
                handlePirates(game,0);
            }
            handleDrones(game);
        }
        
        
        
        else if(game.getEnemy().botName.equals("12217"))
        {
            
            if(game.getTurn() >= 20)
            {
                handlePirates(game,2,hafifd1);
                handlePirates(game,0,hafifd2);
                handlePirates(game,1,hafif);
            }
            else{
                handlePirates(game,2,hafif);
                handlePirates(game,1,hafif);
                handlePirates(game,0,hafif);
                
                
            }
            handleDecoy(game);
            handleDrones(game);
        }
        else if(game.getEnemy().botName.equals("12221"))
        {
               game.debug(game.getEnemy().botName);
        Location loc = new Location(game.getRowCount(),game.getColCount());
        int x = game.getAllMyPirates().size();
        /*if((game.getEnemyLivingDrones().size() > 0))
        {
            Drone Enemy = game.getEnemyLivingDrones().get(defender(game));
            handlePirates(game, 0, Enemy);
        }*/
        if(game.getAllMyPirates().size()>1)
        {
            for(int i=2; i<x;i++)
            {
                if(getCloestIsland(game,game.getAllMyPirates().get(i)).owner != game.getMyself())
                {
                    handlePirates(game,i);
                }
                else if(game.getAllIslands().size() > 1)
                {
                    if(game.getAllIslands().get(0).owner != game.getMyself())
                    {
                        try
                        {
                            handlePirates(game,i,defender(game));
                        }
                        catch(NullPointerException e)
                        {
                            handlePirates(game,true,i);
                        }
                    }
                }
                if(game.getAllIslands().size() == game.getMyIslands().size())
                {
                    if(game.getEnemyCities().size() > 1)
                    {
                        if(game.getMyLivingPirates().size() == 3)
                        {
                            handlePirates(game,i,false);
                        }
                        
                    }
                    else
                    {
                        handlePirates(game,i,true);
                    }
                }
            
            }
        }
        
        if(game.getEnemyLivingDrones().size() > 1 && game.getEnemyCities().size()>1)
        {
            
            if(!tryDecoy(game,game.getMyLivingPirates().get(0)))
            {
                    handlePirates(game,0,defender(game));
            }
            handlePirates(game,1,defender(game));
        }
        else
        {
            if(!tryDecoy(game,game.getMyLivingPirates().get(0)))
            {
                    handlePirates(game,0,0);
            }
            
            handlePirates(game,1,0);
        }
            handleDrones(game);
            handleDecoy(game);
        }
        else if(game.getEnemy().botName.equals("12223"))
        {
            for(int i=3;i<game.getMyLivingPirates().size();i++)
            {
                try{
                    handlePirates(game,i,defender(game));
                    
                }catch(NullPointerException x)
                {
                    handlePirates(game,i,false);
                }
                
                
            }
            if(game.getEnemyLivingDrones().size()>0)
            {
               if(!tryPaintball(game.getMyLivingPirates().get(0),game))
               {
                   handlePirates(game,0,getColestToCity(game));
                   handlePirates(game,1,getColestToCity(game));
                   handlePirates(game,2,getColestToCity(game));
               }
            }
            else{
                handlePirates(game,0,0);
                handlePirates(game,1,0);
                handlePirates(game,2,false);
            }
            handleDecoy(game);
            handleDrones(game,0);
            
        }
        else if(game.getEnemy().botName.equals("12222"))
        {
            for(int i = 1;i<game.getMyLivingPirates().size();i++)
            {
                handlePirates(game,i,1);
            }
            try{
                handlePirates(game,0,defender(game));
            } catch(NullPointerException c)
            {
                handlePirates(game,0,1);
            }
            handleDronesGal(game);
        }
        else if(game.getEnemy().botName.equals("12220"))
        {
            
            if(game.getTurn() >= 737)
            {
                handlePirates(game,0,game.getMyCities().get(0));
            handlePirates(game,1,game.getMyCities().get(0),0);
            handlePirates(game,2,game.getMyCities().get(0),0);
            handlePirates(game,3,game.getMyCities().get(0),0);
            
            handlePirates(game,4,game.getMyCities().get(1),0);
            handlePirates(game,5,game.getMyCities().get(1),0);
            handlePirates(game,6,game.getMyCities().get(1),0);
            handlePirates(game,7,game.getMyCities().get(1),0);
            
            handlePirates(game,8,game.getMyCities().get(2),0);
            handlePirates(game,9,game.getMyCities().get(2),0);
            handlePirates(game,10,game.getMyCities().get(2),0);
                    handlePirates(game,11,game.getMyCities().get(2),0);
            
            if(game.getAllIslands().get(0).owner == game.getMyself())
            {
                handlePirates(game,12,game.getMyCities().get(0),0);
                handlePirates(game,13,game.getMyCities().get(0),0);
            }
            else{
                handlePirates(game,12,0,0);
            handlePirates(game,13,0,0);
            }
            
            if(game.getAllIslands().get(3).owner == game.getMyself())
            {
                handlePirates(game,14,0,0);
            }
            else{
                handlePirates(game,14,0);
            }
            
            handleDronesArm(game);
            handleDecoyArm(game);
            }
            else{
            int i =0;
            handlePirates(game,0,game.getMyCities().get(0));
            handlePirates(game,1,game.getMyCities().get(0),0);
            handlePirates(game,2,game.getMyCities().get(0),0);
            handlePirates(game,3,game.getMyCities().get(0),0);
            
            handlePirates(game,4,game.getMyCities().get(1),0);
            handlePirates(game,5,game.getMyCities().get(1),0);
            handlePirates(game,6,game.getMyCities().get(1),0);
            handlePirates(game,7,game.getMyCities().get(1),0);
            
            handlePirates(game,8,game.getMyCities().get(2),0);
            handlePirates(game,9,game.getMyCities().get(2),0);
            handlePirates(game,10,game.getMyCities().get(2),0);
            handlePirates(game,11,game.getMyCities().get(2));
            
            if(game.getAllIslands().get(0).owner == game.getMyself())
            {
                handlePirates(game,12,game.getMyCities().get(0),0);
                handlePirates(game,13,game.getMyCities().get(0),0);
            }
            else{
                handlePirates(game,12,0,0);
            handlePirates(game,13,0,0);
            }
            
            if(game.getAllIslands().get(3).owner == game.getMyself())
            {
                handlePirates(game,14,0,0);
            }
            else{
                handlePirates(game,14,0);
            }
            
            handleDronesArm(game);
            handleDecoyArm(game);
            }
            
        }
        else if(game.getEnemy().botName.equals("12220"))
        {
            int i=0;
            for(i=1;i<6;i++)
            {
                
                handlePirates(game,i,0);
            }
            for(i=6;i<10;i++)
            {
                handlePirates(game,i,1);
            }
            for(i=10;i<12;i++)
            {
                handlePirates(game,i,3);
            }
            handlePirates(game,13,2);
            handlePirates(game,14,2);
            
            if(game.getAllMyPirates().get(0).isAlive()&&!tryDecoy(game,game.getAllMyPirates().get(0)))
            {
                handlePirates(game,0);
            }
            
           
            handlePirates(game,12,3);
            handleDronesArm(game);
            handleDecoy(game);
        }
        else if(game.getEnemy().botName.equals("12219"))
        {
            handlePirates(game,0,1);
            handlePirates(game,1,1);
            
            handlePirates(game,4,1);
            
            handlePirates(game,3,3);
            
            if(game.getTurn()>=35)
            {
                handlePirates(game,5,4);
            }
            else{
                handlePirates(game,5,3);
            }
            
            handlePirates(game,7,3);
            
            if(game.getAllIslands().get(2).owner != game.getMyself())
            {
                handlePirates(game,2,2,0);
                handlePirates(game,6,2);
            }
            else
            {
                handlePirates(game,2,2,0);
                handlePirates(game,6,2);
            }
            handleDecoy(game);
            handleDrones(game);
        }
        
        else
        {
            game.debug(game.getEnemy().botName);
        Location loc = new Location(game.getRowCount(),game.getColCount());
        int x = game.getAllMyPirates().size();
        /*if((game.getEnemyLivingDrones().size() > 0))
        {
            Drone Enemy = game.getEnemyLivingDrones().get(defender(game));
            handlePirates(game, 0, Enemy);
        }*/
        if(game.getAllMyPirates().size()>1)
        {
            for(int i=2; i<x;i++)
            {
                if(getCloestIsland(game,game.getAllMyPirates().get(i)).owner != game.getMyself())
                {
                    handlePirates(game,i);
                }
                else if(game.getAllIslands().size() > 1)
                {
                    if(game.getAllIslands().get(0).owner != game.getMyself())
                    {
                        try
                        {
                            handlePirates(game,i,defender(game));
                        }
                        catch(NullPointerException e)
                        {
                            handlePirates(game,true,i);
                        }
                    }
                }
                if(game.getAllIslands().size() == game.getMyIslands().size())
                {
                    if(game.getEnemyCities().size() > 1)
                    {
                        if(game.getMyLivingPirates().size() == 3)
                        {
                            handlePirates(game,i,false);
                        }
                        
                    }
                    else
                    {
                        handlePirates(game,i,true);
                    }
                }
            
            }
        }
        
        if(game.getEnemyLivingDrones().size() > 1 && game.getEnemyCities().size()>1)
        {
            
            if(!tryDecoy(game,game.getMyLivingPirates().get(0)))
            {
                    handlePirates(game,0,defender(game));
            }
            handlePirates(game,1,defender(game));
        }
        else
        {
            if(!tryDecoy(game,game.getMyLivingPirates().get(0)))
            {
                    handlePirates(game,0,0);
            }
            
            handlePirates(game,1,0);
        }
            handleDrones(game);
            handleDecoy(game);
        }
        game.debug(game.getEnemy().botName);
        
    }
    

    /**
     * Gives orders to my pirates
     *
     * @param game - the current game state
     */
    private Paintball closetPain(PirateGame game, Pirate p)
    {
        int x =999999;
        Paintball save = null;
        for(Paintball pa : game.getAvailablePaintballs())
        {
            if(p.distance(pa) < x)
            {
                x=p.distance(pa);
                save = pa;
            }
        }
        return save;
        
    }
    
    private boolean tryPaintball(Pirate pirate, PirateGame game) {
    // Check if the pirate already has paintball and that paintballs are there
    if (!pirate.hasPaintball && game.getAvailablePaintballs().size() > 0) {
        // Choose paintball
        Paintball destination = game.getAvailablePaintballs().get(0);
        // Get sail options
        Mover.moveAircraft(pirate, destination, game);
        // Print a message
        return true;
    }

    // Didn't go for paintball
    return false;
    }

    
    private void handleDecoy(PirateGame game) 
    {
        Decoy decoy = game.getMyself().decoy;
        Location loc = new Location(0,0);
        Pirate destination = null;
        // if we have a decoy
        if (decoy != null && game.getEnemyLivingPirates().size()>0) {
            // Choose destination
            destination = getCLosestPirate(game,decoy);
            //loc = new Location(destination.location.row+5,destination.location.col+5);
            loc = destination.location;
            if(decoy.distance(destination) < 7)
            {
                
                Mover.moveAircraft(decoy, loc,game);
            }
            else
            {
                Mover.moveAircraft(decoy, destination,game);
            }
            
        }
    }
    
    private void handleDecoyM(PirateGame game) 
    {
        Decoy decoy = game.getMyself().decoy;
        Location loc = new Location(25,25);
        Location destination = null;
        // if we have a decoy
        if (decoy != null && game.getEnemyLivingPirates().size()>0) {
            // Choose destination
            destination = loc;
            //loc = new Location(destination.location.row+5,destination.location.col+5);
            Mover.moveAircraft(decoy, destination,game);
            
        }
    }
    
    private void handleDecoyArm(PirateGame game) 
    {
        Decoy decoy = game.getMyself().decoy;
        Location loc = new Location(0,28);
        Location destination = null;
        // if we have a decoy
        if (decoy != null && game.getEnemyLivingPirates().size()>0) {
            // Choose destination
            destination = loc;
            //loc = new Location(destination.location.row+5,destination.location.col+5);
            Mover.moveAircraft(decoy, destination,game);
            
        }
    }
    
    
    private Pirate getCLosestPirate(PirateGame game, Decoy dec)
    {
        int x= 99999;
        Pirate save = null;
        for(Pirate p : game.getEnemyLivingPirates())
        {
            if(dec.distance(p) < x)
            {
                x= dec.distance(p);
                save = p;
            }
        }
        return save;
    }
    
    private boolean tryDecoy(PirateGame game,Pirate pirate) {
    // Check if the player can decoy a pirate
    if (pirate.owner.turnsToDecoyReload == 0) {
        // Whoosh
        game.decoy(pirate);
        // print a message
        game.debug("pirate " + pirate + " decoys itself");
        // Did decoy
        return true;
    }

    // didn't decoy
    return false;
    }
    
    private Drone getColestToCity(PirateGame game)
    {
        int x = 9999;
        Drone save = null;
        for(Drone d : game.getEnemyLivingDrones())
        {
            if(game.getEnemyCities().get(0).distance(d) < x)
            {
                x = game.getEnemyCities().get(0).distance(d);
                save = d;
            }
        }
        return save;
    }

    
    private Island getCloestIsland(PirateGame game, Pirate p)
    {
        int x = 99999;
        Island save = null;
        for(Island i : game.getAllIslands())
        {
            if(p.distance(i) < x)
            {
                x= p.distance(i);
                save = i;
            }
        }
        return save;
    }
    private Island getFarIsland(PirateGame game, Pirate p)
    {
        int x = 0;
        Island save = null;
        for(Island i : game.getAllIslands())
        {
            if(p.distance(i) > x)
            {
                x= p.distance(i);
                save = i;
            }
        }
        return save;
    }
    
    
    
    private void handlePirates(PirateGame game, int ship) {
        // Go over all of my pirates
            Pirate p = game.getAllMyPirates().get(ship);
            
            // Try to attack, if you didn't - move to an island
            if (!Attacker.tryAttack(p, game) && !tryPaintball(p, game)) {
                // Choose destination
                Island destination = getCloestIsland(game,p);
                //City destination = game.getEnemyCities().get(0);
                // Send to destination
				Mover.moveAircraft(p, destination, game);
            }
        
    }
    
    private void handlePirates(PirateGame game,boolean far, int ship) {
        // Go over all of my pirates
            Pirate p = game.getAllMyPirates().get(ship);
            
            // Try to attack, if you didn't - move to an island
            if (!Attacker.tryAttack(p, game)) {
                // Choose destination
                Island destination = getCloestIsland(game,p);
                if(far)
                {
                    destination = getFarIsland(game,p);
                }
                //City destination = game.getEnemyCities().get(0);
                // Send to destination
				Mover.moveAircraft(p, destination, game);
            }
        
    }
    
    
    private void handlePirates(PirateGame game, int ship, int isl) {
        // Go over all of my pirates
            Pirate p = game.getAllMyPirates().get(ship);
            
            // Try to attack, if you didn't - move to an island
            
            if (!Attacker.tryAttack(p, game)) {
                // Choose destination
                Island destination = game.getAllIslands().get(isl);
                //City destination = game.getEnemyCities().get(0);
                // Send to destination
				Mover.moveAircraft(p, destination, game);
            }
        
    }
    
    private void handlePirates(PirateGame game, int ship, int isl,int x) {
        // Go over all of my pirates
            Pirate p = game.getAllMyPirates().get(ship);
            
            // Try to attack, if you didn't - move to an island
            if (!Attacker.tryAttack(p, game)) {
                // Choose destination
                Island destination = game.getAllIslands().get(isl);
                //City destination = game.getEnemyCities().get(0);
                // Send to destination
				Mover.moveAircraftG(p, destination, game);
            }
        
    }
    
    private void handlePirates(PirateGame game, int ship, boolean My) {
        // Go over all of my pirates
        
            Pirate p = game.getAllMyPirates().get(ship);
            City destination = null;
            // Try to attack, if you didn't - move to an island
            if (!Attacker.tryAttack(p, game)) {
                // Choose destination
                //Island destination = game.getAllIslands().get(isl);
                //City destination = game.getEnemyCities().get(0);
                if(game.getNeutralCities().size() > 0)
                {
                    destination = game.getNeutralCities().get(0);
                }
                else
                {
                    destination = game.getMyCities().get(0);    
                }
                if(!My)
                {
                    destination = game.getEnemyCities().get(0);
                }
                
                // Send to destination
				Mover.moveAircraft(p, destination, game);
            }
        
    }
    
    private void handlePirates(PirateGame game, int ship, boolean My, int x) {
        // Go over all of my pirates
        
            Pirate p = game.getAllMyPirates().get(ship);
            City destination = null;
            // Try to attack, if you didn't - move to an island
            if (!Attacker.tryAttack(p, game)) {
                // Choose destination
                //Island destination = game.getAllIslands().get(isl);
                //City destination = game.getEnemyCities().get(0);
                if(game.getNeutralCities().size() > 0)
                {
                    destination = game.getNeutralCities().get(0);
                }
                else
                {
                    destination = game.getMyCities().get(0);    
                }
                if(!My)
                {
                    destination = game.getEnemyCities().get(0);
                }
                
                // Send to destination
				Mover.moveAircraftG(p, destination, game);
            }
        
    }
    
    private void handlePiratesFinal(PirateGame game, int ship) {
        // Go over all of my pirates
        
            Pirate p = game.getAllMyPirates().get(ship);
            City destination = null;
            // Try to attack, if you didn't - move to an island
            if (!Attacker.tryAttack(p, game)) {
                // Choose destination
                //Island destination = game.getAllIslands().get(isl);
                //City destination = game.getEnemyCities().get(0);
                destination = game.getMyCities().get(0); 
                
                // Send to destination
				Mover.moveAircraft(p, destination, game);
            }
        
    }
    
    private void handlePirates(PirateGame game, int ship,Drone d) {
        // Go over all of my pirates
        
            Pirate p = game.getAllMyPirates().get(ship);
            Drone destination = d;
            // Try to attack, if you didn't - move to an island
            if (!Attacker.tryAttack(p, game)) {
                // Choose destination
                // Send to destination
				Mover.moveAircraft(p, destination, game);
            }
        
    }
    
    private void handlePirates(PirateGame game, int ship,Drone d, int x) {
        // Go over all of my pirates
        
            Pirate p = game.getAllMyPirates().get(ship);
            Drone destination = d;
            // Try to attack, if you didn't - move to an island
            if (!Attacker.tryAttack(p, game)) {
                // Choose destination
                // Send to destination
				Mover.moveAircraftG(p, destination, game);
            }
        
    }
    
    private void handlePirates(PirateGame game, int ship,Location loc) {
        // Go over all of my pirates
        
            Pirate p = game.getAllMyPirates().get(ship);
            // Try to attack, if you didn't - move to an island
            if (!Attacker.tryAttack(p, game)) {
                // Choose destination
                // Send to destination
				Mover.moveAircraft(p, loc, game);
            }
        
    }
    
    private void handlePirates(PirateGame game, int ship,City c) {
        // Go over all of my pirates
        
            Pirate p = game.getAllMyPirates().get(ship);
            // Try to attack, if you didn't - move to an island
            if (!Attacker.tryAttack(p, game)) {
                // Choose destination
                // Send to destination
				Mover.moveAircraft(p, c, game);
            }
        
    }
    
    private void handlePirates(PirateGame game, int ship,City c,int x) {
        // Go over all of my pirates
        
            Pirate p = game.getAllMyPirates().get(ship);
            // Try to attack, if you didn't - move to an island
            if (!Attacker.tryAttack(p, game)) {
                // Choose destination
                // Send to destination
				Mover.moveAircraftG(p, c, game);
            }
        
    }
    
    private void handlePiratesMitz(PirateGame game, int ship,Location loc) {
        // Go over all of my pirates
        
            Pirate p = game.getAllMyPirates().get(ship);
            // Try to attack, if you didn't - move to an island
            if (!Attacker.tryAttack(p, game,game.getEnemyLivingPirates().get(0))) {
                // Choose destination
                // Send to destination
				Mover.moveAircraft(p,game.getEnemyLivingPirates().get(0) , game);
            }
        
    }
    
    private void handlePirates(PirateGame game, int ship,Location loc,int x) {
        // Go over all of my pirates
        
            Pirate p = game.getAllMyPirates().get(ship);
            // Try to attack, if you didn't - move to an island
            if (!Attacker.tryAttack(p, game)) {
                // Choose destination
                // Send to destination
				Mover.moveAircraftG(p, loc, game);
            }
        
    }
    
    /*private Drone closestEnemy(PirateGame game,Pirate p)
    {
        int x = 99999;
        Drone close=null;
        if(game.getMyCities().size() > 0)
        {
            for(City my : game.getMyCities())
            {
                if(p.distance(my) < x)
                {
                    x = d.distance(my);
                    close = my;
                }
            }
        }
    }*/
    private City closet(PirateGame game, Drone d)
    {
        int x = 99999;
        City close=null;
        if(game.getMyCities().size() > 0)
        {
            for(City my : game.getMyCities())
            {
                if(d.distance(my) < x)
                {
                    x = d.distance(my);
                    close = my;
                }
            }
        }
        if(game.getNeutralCities().size() > 0)
        {
            for(City nut : game.getNeutralCities())
            {
                if(d.distance(nut) < x)
                {
                    x = d.distance(nut);
                    close = nut;
                }
            }
        }
        return close;
    }
    
    private Drone defender(PirateGame game)
    {
        int x = 999999;
        Drone d = null;
        if(game.getEnemyLivingDrones().size() > 0)
        {
            for (Drone drone : game.getEnemyLivingDrones())
            {
                if(game.getEnemyCities().size()<1)
                {
                    if(game.getNeutralCities().get(0).distance(drone)<x)
                    {
                    x = game.getNeutralCities().get(0).distance(drone);
                    d = drone;
                    }
                }
                else
                {
                    if(game.getEnemyCities().get(0).distance(drone)<x)
                    {
                    x = game.getEnemyCities().get(0).distance(drone);
                    d = drone;
                    }
                }
                
            }
            return d;
        }
        return null;
        
    }
    

    /**
     * Gives orders to my drones
     *
     * @param game - the current game state
     */
    private void handleDronesDvora(PirateGame game) {
        // Go over all of my drones
        for (Drone drone : game.getMyLivingDrones()) {
            // Choose a destination
            
            if(drone == game.getMyLivingDrones().get(0))
            {
                Location save = new Location(15,5);
                Mover.moveAircraft(drone, save, game); 
            }
            /*else if(game.getEnemyLivingPirates().size() >1)
            {
                if(drone.distance(game.getEnemyLivingPirates().get(0)) < 7)
                {
                //Location save = new Location(game.getEnemyLivingPirates().get(0).location.row+5, game.getEnemyLivingPirates().get(0).location.col);
                //Mover.moveAircraft(drone, save, game); 
                //int f = game.getMyCities().size()-1;
                    City destination = game.getMyCities().get(0);
                    //Island destination = game.getAllIslands().get(0);
                    // Send to destination game)
			        Mover.moveAircraft(drone, destination, game);
                }
            }*/
            else
            {
                //int f = game.getMyCities().size()-1;
                City destination = game.getMyCities().get(0);
                //Island destination = game.getAllIslands().get(0);
                // Send to destination game)
			    Mover.moveAircraft(drone, destination, game); 
            }
            
        }
    }
    
    private void handleDronesArm(PirateGame game) {
        // Go over all of my drones
        for (Drone drone : game.getMyLivingDrones()) {
            // Choose a destination
            
                //int f = game.getMyCities().size()-1;
                City destination = game.getMyCities().get(0);
                //Island destination = game.getAllIslands().get(0);
                // Send to destination game)
			    Mover.moveAircraftG(drone, destination, game); 
            
            
        }
    }
    
    
    private void handleDronesArm2(PirateGame game) {
        // Go over all of my drones
        City destination = null;
        for (Drone drone : game.getMyLivingDrones()) {
            if(game.getEnemyLivingPirates().size() >1)
            {
                if(drone.distance(game.getEnemyLivingPirates().get(0)) < 7)
                {
                     Location save = new Location(game.getEnemyLivingPirates().get(0).location.row+5, game.getEnemyLivingPirates().get(0).location.col);
                    if(game.getAllEnemyPirates().get(10).isAlive())
                    {
                         save = new Location(game.getAllEnemyPirates().get(10).location.row, game.getAllEnemyPirates().get(10).location.col+5);
                    }
               
                //Mover.moveAircraft(drone, save, game); 
                //int f = game.getMyCities().size()-1;
                    //City destination = game.getMyCities().get(0);
			        Mover.moveAircraft(drone, save, game);
                }
                else
                {
                //int f = game.getMyCities().size()-1;
                    if(game.getNeutralCities().size() >0)
                    {
                        destination = game.getNeutralCities().get(0);
                    }
                    else
                    {
                        destination = game.getMyCities().get(0);
                    }
                    
                
                //Island destination = game.getAllIslands().get(0);
                // Send to destination game)
			    Mover.moveAircraft(drone, destination, game); 
                }
            }
            
        }
    }
    
    private void handleDronesGal(PirateGame game) {
        // Go over all of my drones
        City destination = null;
        for (Drone drone : game.getMyLivingDrones()) {
            if(game.getEnemyLivingPirates().size() >1)
            {
                if(drone.distance(game.getEnemyLivingPirates().get(0)) < 7)
                {
                Location save = new Location(game.getEnemyLivingPirates().get(0).location.row, game.getEnemyLivingPirates().get(0).location.col+5);
                //Mover.moveAircraft(drone, save, game); 
                //int f = game.getMyCities().size()-1;
                    //City destination = game.getMyCities().get(0);
			        Mover.moveAircraft(drone, save, game);
                }
                else
                {
                //int f = game.getMyCities().size()-1;
                    if(game.getNeutralCities().size() >0)
                    {
                        destination = game.getNeutralCities().get(0);
                    }
                    else
                    {
                        destination = game.getMyCities().get(0);
                    }
                    
                
                //Island destination = game.getAllIslands().get(0);
                // Send to destination game)
			    Mover.moveAircraft(drone, destination, game); 
                }
            }
            
        }
    }
    private void handleDrones(PirateGame game) {
        // Go over all of my drones
        for (Drone drone : game.getMyLivingDrones()) {
            // Choose a destinatio
            City destination=null;
            /*if(game.getNeutralCities().size() > 0)
            {
                 destination = game.getNeutralCities().get(0);
            }
            else
            {
                destination=game.getMyCities().get(0);
            }*/
            destination = closet(game,drone);
            //Island destination = game.getAllIslands().get(0);
            // Send to destination game)
			Mover.moveAircraft(drone, destination, game);
        }
    }
    
    private void handleDrones(PirateGame game, int x) {
        // Go over all of my drones
        for (Drone drone : game.getMyLivingDrones()) {
            // Choose a destinatio
            City destination=null;
            /*if(game.getNeutralCities().size() > 0)
            {
                 destination = game.getNeutralCities().get(0);
            }
            else
            {
                destination=game.getMyCities().get(0);
            }*/
            destination = closet(game,drone);
            //Island destination = game.getAllIslands().get(0);
            // Send to destination game)
			Mover.moveAircraftG(drone, destination, game);
        }
    }
    
    private void handleDronesFinal(PirateGame game) {
        City destination;
        Enterprise destination1;
        for (Drone drone : game.getMyLivingDrones()) {
            if(drone.initialLocation.col == game.getAllIslands().get(0).location.col || drone.initialLocation.col == game.getAllIslands().get(1).location.col)
            {
            	
            	if(game.getMyDome() != null)
            	{
            		destination = game.getNeutralCities().get(0);
            		Mover.moveAircraft(drone, destination, game);
            	}
            	else
            	{
            		if(drone.distance(game.getEnterprise()) > drone.distance(game.getNeutralCities().get(0)))
            		{
            		    destination = game.getNeutralCities().get(0);
            		    Mover.moveAircraft(drone, destination, game);
            		}
            		else{
            		    destination1 = game.getEnterprise();
            		    Mover.moveAircraft(drone, destination1, game);
            		}
            		
            	}
            	
            }
            else
            {
            	destination = game.getNeutralCities().get(0);
            	Mover.moveAircraft(drone, destination, game);
            	
            }
            //Island destination = game.getAllIslands().get(0);
        }
    }
    
    private void handleDrones(int x,PirateGame game) {
        // Go over all of my drones
        for (Drone drone : game.getMyLivingDrones()) {
            // Choose a destinatio
            City destination=null;
            /*if(game.getNeutralCities().size() > 0)
            {
                 destination = game.getNeutralCities().get(0);
            }
            else
            {
                destination=game.getMyCities().get(0);
            }*/
            destination = game.getMyCities().get(2);
            //Island destination = game.getAllIslands().get(0);
            // Send to destination game)
			Mover.moveAircraft(drone, destination, game);
        }
    }
    
    private void handleDronesMain(PirateGame game) {
        // Go over all of my drones
        for (Drone drone : game.getMyLivingDrones()) {
            // Choose a destination
            
                //int f = game.getMyCities().size()-1;
                City destination = game.getNeutralCities().get(0);
                //Island destination = game.getAllIslands().get(0);
                // Send to destination game)
			    Mover.moveAircraft(drone, destination, game); 
            
            
        }
    }
}

