# StreamControl

**This is a [Paper](https://github.com/PaperMC/Paper) plugin!**

Control event notification message stream.

## Commands and Permissions

| Command               | Description          | Permission        |
| --------------------- | -------------------- | ----------------- |
| /streamcontrol        | Show version         | -                 |
| /streamcontrol reload | Reload configuration | streamcontrol.use |

## Configuration

```yaml
# You can use color with § symbol.
# %player% will be converted to player display name. Can be repeated.

# boolean : send join message.
join-message-enabled: true

# string : join message.
join-message: "§a§lWelcome %player%!"

# boolean : send quit message.
quit-message-enabled: false

# boolean : only send join message to new player.
first-join-only: true

# string : first join custom message, can be emptied to use default message.
first-join-message: '§d§l%player% has joined for the first time!'

# boolean : send MOTD on join.
join-motd-enabled: true

# list of string : MOTD messages, 
join-motd-message:
  - "§aThis is a MOTD, can be disabled or changed in configuration file."

```