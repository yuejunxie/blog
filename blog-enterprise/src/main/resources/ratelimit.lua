local key = KEYS[1]
local limit = tonumber(ARGV[1])
local current = tonumber(redis.get("GET", key))
if current + 1 > limit then
    return 0;
else
    redis.call("INCRBY", key, "1")
    redis.call("EXPIRE", key, "2")
end
return 1