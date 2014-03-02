package com.builtbroken.common;

/** Mainly a prefab for creating defined user classes. Currently it only stores the user's name.
 * 
 * @author Robert Seifert */
public class User
{
    protected String username;

    public User(String username)
    {
        this.username = username;
    }

    public String getName()
    {
        return this.username;
    }

    @Override
    public boolean equals(Object obj)
    {
        return obj instanceof User && ((User) obj).getName().equalsIgnoreCase(this.getName());
    }

    @Override
    public String toString()
    {
        return "[User:" + this.getName() + "]";
    }
}
