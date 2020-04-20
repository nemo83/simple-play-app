#!/usr/bin/env bash
set -x

pid=0

# SIGTERM-handler
term_handler() {
  if [ $pid -ne 0 ]; then
    kill -SIGTERM "$children"
    ## Waiting children to gracefully die
    sleep 30
    ## Killing now actual the process launcher! Bye bye
    kill -SIGTERM "$pid"
    wait "$pid"
  fi
  exit 143; # 128 + 15 -- SIGTERM
}

# setup handlers
# on callback, kill the last background process, which is `tail -f /dev/null` and execute the specified handler
trap 'kill ${!}; term_handler' SIGTERM

# run application
"$@" &
pid="$!"
echo "$pid"

# Waiting grand-child process has started
children=""
child_pids() {
  children=$(ps --ppid $pid | awk 'NR>1 { printf $1 }')
}

while [ -z "$children"  ]; do
  sleep 1
  child_pids
done

echo "$children"

# wait forever, but keep allowing logs to flow freely
while true
do
  tail -f /dev/null & wait ${!}
done