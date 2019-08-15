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
# boolean : send join message.
join-message-enabled: true

# boolean : send quit message.
quit-message-enabled: false

# boolean : only send join message to new player.
first-join-only: true

# string : first join custom message, can be emptied to use default message.
first-join-message: '&d&l%player% has joined for the first time!'
```